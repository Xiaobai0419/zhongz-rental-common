package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzValidateCode;

import java.util.List;

/**
 * 验证码 数据层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface ZhongzValidateCodeMapper 
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
	public ZhongzValidateCode selectZhongzValidateCode(ZhongzValidateCode zhongzValidateCode);

	/**
     * 查询验证码列表
     * 
     * @param zhongzValidateCode 验证码信息
     * @return 验证码集合
     */
	public List<ZhongzValidateCode> selectZhongzValidateCodeList(ZhongzValidateCode zhongzValidateCode);
	
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
	 * 根据手机号和验证码业务类型修改验证码
	 *
	 * @param zhongzValidateCode 验证码信息
	 * @return 结果
	 */
	public int updateZhongzValidateCodeByMobileAndType(ZhongzValidateCode zhongzValidateCode);

	/**
	 * 删除验证码（逻辑）
	 *
	 * @param id 验证码ID
	 * @return 结果
	 */
	public int deleteZhongzValidateCodeById1(String id);

	/**
	 * 批量删除验证码（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzValidateCodeByIds1(String[] ids);

	/**
     * 删除验证码
     * 
     * @param id 验证码ID
     * @return 结果
     */
	public int deleteZhongzValidateCodeById(String id);
	
	/**
     * 批量删除验证码
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzValidateCodeByIds(String[] ids);
	
}