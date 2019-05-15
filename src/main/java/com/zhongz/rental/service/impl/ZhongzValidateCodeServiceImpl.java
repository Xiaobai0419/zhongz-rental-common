package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.common.utils.SmsSendUtils;
import com.zhongz.rental.domain.ZhongzValidateCode;
import com.zhongz.rental.mapper.ZhongzValidateCodeMapper;
import com.zhongz.rental.result.base.Result;
import com.zhongz.rental.service.IZhongzValidateCodeService;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 验证码 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Log
@Service
public class ZhongzValidateCodeServiceImpl implements IZhongzValidateCodeService
{
	@Autowired
	private ZhongzValidateCodeMapper zhongzValidateCodeMapper;

	/**
     * 查询验证码信息
     * 
     * @param id 验证码ID
     * @return 验证码信息
     */
    @Override
	public ZhongzValidateCode selectZhongzValidateCodeById(String id)
	{
	    return zhongzValidateCodeMapper.selectZhongzValidateCodeById(id);
	}

	/**
	 * 根据手机号和验证码业务类型查询验证码信息
	 *
	 * @param zhongzValidateCode 验证码信息
	 * @return 验证码信息
	 */
	@Override
	public Result selectZhongzValidateCode(ZhongzValidateCode zhongzValidateCode)
	{
		Result result = new Result();
		String mobile = zhongzValidateCode.getMobile();
		String code = zhongzValidateCode.getCode();
		if(StringUtils.isBlank(mobile) || StringUtils.isBlank(code)) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("缺少手机号或验证码信息");
			return result;
		}
		//查询该手机该类型唯一验证码，是否匹配传入验证码，匹配返回成功，否则匹配失败
		ZhongzValidateCode validateCode = zhongzValidateCodeMapper.selectZhongzValidateCode(zhongzValidateCode);
		if(validateCode == null || StringUtils.isBlank(validateCode.getCode()) || !code.equals(validateCode.getCode())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("验证码错误");
			return result;
		}
		result.setSuccess(true);
		result.setResultCode(200);
		result.setMessage("验证码验证成功");
		return result;
	}
	
	/**
     * 查询验证码列表
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 验证码集合
     */
	@Override
	public List<ZhongzValidateCode> selectZhongzValidateCodeList(ZhongzValidateCode zhongzValidateCode)
	{
	    return zhongzValidateCodeMapper.selectZhongzValidateCodeList(zhongzValidateCode);
	}

	/**
	 * 获取验证码
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
	@Override
	public Result get(ZhongzValidateCode zhongzValidateCode)
	{
		Result result = new Result();
		String mobile = zhongzValidateCode.getMobile();
		if(StringUtils.isBlank(mobile)) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("缺少手机号信息");
			return result;
		}
		//使用手机号调用验证码获取第三方接口，获取验证码并向该手机发送验证码
		String code = SmsSendUtils.generateRandomValidateCode();
		boolean smsResult = false;
		try {
			smsResult = SmsSendUtils.sendSmsValidateCode(mobile,code);
		}catch (Exception e) {
			log.info("获取短信验证码服务端错误");
			e.printStackTrace();
		}
		if(!smsResult) {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("验证码获取失败");
			return result;
		}
		zhongzValidateCode.setCode(code);
		//查询该手机该类型验证码
		ZhongzValidateCode validateCode = zhongzValidateCodeMapper.selectZhongzValidateCode(zhongzValidateCode);
		//如有，更新成最新验证码，保证任何时间有唯一一条
		if(validateCode != null) {
			zhongzValidateCode.preUpdate();
			zhongzValidateCodeMapper.updateZhongzValidateCodeByMobileAndType(zhongzValidateCode);
		}
		//否则插入验证码
		else {
			zhongzValidateCode.preInsert();
			zhongzValidateCodeMapper.insertZhongzValidateCode(zhongzValidateCode);
		}
		result.setSuccess(true);
		result.setResultCode(200);
		result.setMessage("验证码获取成功");
		return result;
	}

    /**
     * 新增验证码
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 结果
     */
	@Override
	public int insertZhongzValidateCode(ZhongzValidateCode zhongzValidateCode)
	{
	    return zhongzValidateCodeMapper.insertZhongzValidateCode(zhongzValidateCode);
	}
	
	/**
     * 修改验证码
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 结果
     */
	@Override
	public int updateZhongzValidateCode(ZhongzValidateCode zhongzValidateCode)
	{
	    return zhongzValidateCodeMapper.updateZhongzValidateCode(zhongzValidateCode);
	}

	/**
     * 删除验证码对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzValidateCodeByIds(String ids)
	{
		return zhongzValidateCodeMapper.deleteZhongzValidateCodeByIds1(Convert.toStrArray(ids));
	}
	
}
