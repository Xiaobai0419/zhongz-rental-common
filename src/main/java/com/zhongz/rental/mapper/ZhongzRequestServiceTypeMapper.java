package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzRequestServiceType;

import java.util.List;

/**
 * 请求服务类型 数据层
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
public interface ZhongzRequestServiceTypeMapper 
{
	/**
     * 查询请求服务类型信息
     * 
     * @param id 请求服务类型ID
     * @return 请求服务类型信息
     */
	public ZhongzRequestServiceType selectZhongzRequestServiceTypeById(String id);
	
	/**
     * 查询请求服务类型列表
     * 
     * @param zhongzRequestServiceType 请求服务类型信息
     * @return 请求服务类型集合
     */
	public List<ZhongzRequestServiceType> selectZhongzRequestServiceTypeList(ZhongzRequestServiceType zhongzRequestServiceType);

	/**
	 * 查询报修类型列表
	 *
	 * @return 请求服务类型集合
	 */
	public List<ZhongzRequestServiceType> selectZhongzRequestServiceRepair();

	/**
	 * 查询保洁类型列表
	 *
	 * @return 请求服务类型集合
	 */
	public List<ZhongzRequestServiceType> selectZhongzRequestServiceCleaning();

	/**
     * 新增请求服务类型
     * 
     * @param zhongzRequestServiceType 请求服务类型信息
     * @return 结果
     */
	public int insertZhongzRequestServiceType(ZhongzRequestServiceType zhongzRequestServiceType);
	
	/**
     * 修改请求服务类型
     * 
     * @param zhongzRequestServiceType 请求服务类型信息
     * @return 结果
     */
	public int updateZhongzRequestServiceType(ZhongzRequestServiceType zhongzRequestServiceType);

	/**
	 * 删除请求服务类型（逻辑）
	 *
	 * @param id 请求服务类型ID
	 * @return 结果
	 */
	public int deleteZhongzRequestServiceTypeById1(String id);

	/**
	 * 批量删除请求服务类型（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzRequestServiceTypeByIds1(String[] ids);

	/**
     * 删除请求服务类型
     * 
     * @param id 请求服务类型ID
     * @return 结果
     */
	public int deleteZhongzRequestServiceTypeById(String id);
	
	/**
     * 批量删除请求服务类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzRequestServiceTypeByIds(String[] ids);
	
}