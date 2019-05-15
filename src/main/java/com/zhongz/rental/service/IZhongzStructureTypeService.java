package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzStructureType;

import java.util.List;

/**
 * 户型 服务层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface IZhongzStructureTypeService 
{
	/**
     * 查询户型信息
     * 
     * @param id 户型ID
     * @return 户型信息
     */
	public ZhongzStructureType selectZhongzStructureTypeById(String id);
	
	/**
     * 查询户型列表
     * 
     * @param zhongzStructureType 户型信息
     * @return 户型集合
     */
	public List<ZhongzStructureType> selectZhongzStructureTypeList(ZhongzStructureType zhongzStructureType);

	/**
	 * 查询户型列表
	 *
	 * @return 户型集合
	 */
	public List<ZhongzStructureType> selectZhongzStructureTypeList();

	/**
     * 新增户型
     * 
     * @param zhongzStructureType 户型信息
     * @return 结果
     */
	public int insertZhongzStructureType(ZhongzStructureType zhongzStructureType);
	
	/**
     * 修改户型
     * 
     * @param zhongzStructureType 户型信息
     * @return 结果
     */
	public int updateZhongzStructureType(ZhongzStructureType zhongzStructureType);
		
	/**
     * 删除户型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzStructureTypeByIds(String ids);
	
}
