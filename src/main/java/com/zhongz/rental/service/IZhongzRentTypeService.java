package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzRentType;

import java.util.List;

/**
 * 租赁时长类别 服务层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface IZhongzRentTypeService 
{
	/**
     * 查询租赁时长类别信息
     * 
     * @param id 租赁时长类别ID
     * @return 租赁时长类别信息
     */
	public ZhongzRentType selectZhongzRentTypeById(String id);
	
	/**
     * 查询租赁时长类别列表
     * 
     * @param zhongzRentType 租赁时长类别信息
     * @return 租赁时长类别集合
     */
	public List<ZhongzRentType> selectZhongzRentTypeList(ZhongzRentType zhongzRentType);
	
	/**
     * 新增租赁时长类别
     * 
     * @param zhongzRentType 租赁时长类别信息
     * @return 结果
     */
	public int insertZhongzRentType(ZhongzRentType zhongzRentType);
	
	/**
     * 修改租赁时长类别
     * 
     * @param zhongzRentType 租赁时长类别信息
     * @return 结果
     */
	public int updateZhongzRentType(ZhongzRentType zhongzRentType);
		
	/**
     * 删除租赁时长类别信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzRentTypeByIds(String ids);
	
}
