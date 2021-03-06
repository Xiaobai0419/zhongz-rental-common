package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzEstate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小区 数据层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface ZhongzEstateMapper 
{
	/**
     * 查询小区信息
     * 
     * @param id 小区ID
     * @return 小区信息
     */
	public ZhongzEstate selectZhongzEstateById(String id);
	
	/**
     * 查询小区列表
     * 
     * @param zhongzEstate 小区信息
     * @return 小区集合
     */
	public List<ZhongzEstate> selectZhongzEstateList(ZhongzEstate zhongzEstate);

	/**
	 * 查询小区列表
	 *
	 * @return 小区集合
	 */
	public List<ZhongzEstate> selectZhongzEstateAllList();

	/**
	 * 批量查询小区列表
	 *
	 * @param ids 需要查询的数据ID
	 * @return 小区集合
	 */
	public List<ZhongzEstate> selectZhongzEstateList1(String[] ids);

	/**
	 * 名称关键字查询小区列表
	 *
	 * @param name 小区名称关键字
	 * @return 小区集合
	 */
	public List<ZhongzEstate> selectZhongzEstateList2(@Param("name") String name);

	/**
     * 新增小区
     * 
     * @param zhongzEstate 小区信息
     * @return 结果
     */
	public int insertZhongzEstate(ZhongzEstate zhongzEstate);
	
	/**
     * 修改小区
     * 
     * @param zhongzEstate 小区信息
     * @return 结果
     */
	public int updateZhongzEstate(ZhongzEstate zhongzEstate);

	/**
	 * 删除小区（逻辑）
	 *
	 * @param id 小区ID
	 * @return 结果
	 */
	public int deleteZhongzEstateById1(String id);

	/**
	 * 批量删除小区（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzEstateByIds1(String[] ids);

	/**
     * 删除小区
     * 
     * @param id 小区ID
     * @return 结果
     */
	public int deleteZhongzEstateById(String id);
	
	/**
     * 批量删除小区
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzEstateByIds(String[] ids);
	
}