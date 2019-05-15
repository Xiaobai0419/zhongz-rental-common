package com.zhongz.rental.service;

import java.util.List;
import java.util.Map;

import com.zhongz.rental.domain.ZhongzServiceType;

/**
 * 服务类型 服务层
 * 
 * @author ruoyi
 * @date 2019-04-30
 */
public interface IZhongzServiceTypeService 
{
	/**
     * 查询服务类型信息
     * 
     * @param id 服务类型ID
     * @return 服务类型信息
     */
	public ZhongzServiceType selectZhongzServiceTypeById(String id);
	
	/**
     * 查询服务类型列表
     * 
     * @param zhongzServiceType 服务类型信息
     * @return 服务类型集合
     */
	public List<ZhongzServiceType> selectZhongzServiceTypeList(ZhongzServiceType zhongzServiceType);
	
	/**
     * 新增服务类型
     * 
     * @param zhongzServiceType 服务类型信息
     * @return 结果
     */
	public int insertZhongzServiceType(ZhongzServiceType zhongzServiceType);
	
	/**
     * 修改服务类型
     * 
     * @param zhongzServiceType 服务类型信息
     * @return 结果
     */
	public int updateZhongzServiceType(ZhongzServiceType zhongzServiceType);
		
	/**
     * 删除服务类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzServiceTypeByIds(String ids);
	
	public int updateZhongzServiceTypeByIds(Map<String, Object> params, String ids);
	
}
