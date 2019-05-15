package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzValidateCode;
import com.zhongz.rental.result.base.Result;

import java.util.List;

/**
 * 验证码 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IZhongzValidateCodeService 
{
	/**
     * 查询验证码信息
     * 
     * @param id 验证码ID
     * @return 验证码信息
     */
	public ZhongzValidateCode selectZhongzValidateCodeById(String id);

	/**
	 * 根据手机号和验证码业务类型查询验证码信息
	 *
	 * @param zhongzValidateCode 验证码信息
	 * @return 验证码信息
	 */
	public Result selectZhongzValidateCode(ZhongzValidateCode zhongzValidateCode);

	/**
     * 查询验证码列表
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 验证码集合
     */
	public List<ZhongzValidateCode> selectZhongzValidateCodeList(ZhongzValidateCode zhongzValidateCode);

	/**
	 * 获取验证码
	 */
	public Result get(ZhongzValidateCode zhongzValidateCode);

	/**
     * 新增验证码
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 结果
     */
	public int insertZhongzValidateCode(ZhongzValidateCode zhongzValidateCode);
	
	/**
     * 修改验证码
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 结果
     */
	public int updateZhongzValidateCode(ZhongzValidateCode zhongzValidateCode);
		
	/**
     * 删除验证码信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzValidateCodeByIds(String ids);
	
}
