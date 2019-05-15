package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzHouse;
import com.zhongz.rental.param.ZhongzHouseParam;
import com.zhongz.rental.param.ZhongzHouseRentType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房屋 数据层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface ZhongzHouseMapper 
{
	/**
     * 查询房屋信息
     * 
     * @param id 房屋ID
     * @return 房屋信息
     */
	public ZhongzHouse selectZhongzHouseById(String id);

	/**
	 * 查询单个房屋租期类别列表
	 *
	 * @param id 房屋ID
	 * @return 单个房屋租期类别列表
	 */
	public List<ZhongzHouseRentType> selectZhongzHouseRentTypesById(String id);

	/**
	 * 所有前端显示未租整租房子id
	 *
	 * @return 房屋集合
	 */
	public List<String> selectZhongzHouseSoloRentIds();

	/**
	 * 所有标签选择房子id
	 *
	 * @return 房屋集合
	 */
	public List<String> selectZhongzHouseTagedIds(List<String> tagIds);

	/**
	 * 所有关联指定活动房子id
	 *
	 * @return 房屋集合
	 */
	public List<String> selectZhongzHouseEventedIds(@Param("eventId") String eventId);

	/**
     * 所有前端显示未租整租/合租房子
     * 
     * @return 房屋集合
     */
	public List<ZhongzHouse> selectZhongzHouseRentList(ZhongzHouseParam zhongzHouseParam);

	/**
	 * 批量查询房屋列表
	 *
	 * @return 房屋集合
	 */
	public List<ZhongzHouse> selectZhongzHouseByIds(List<String> ids);

	/**
	 * 查询房屋列表
	 *
	 * @param zhongzHouse 房屋信息
	 * @return 房屋集合
	 */
	public List<ZhongzHouse> selectZhongzHouseList(ZhongzHouse zhongzHouse);

	/**
     * 新增房屋
     * 
     * @param zhongzHouse 房屋信息
     * @return 结果
     */
	public int insertZhongzHouse(ZhongzHouse zhongzHouse);
	
	/**
     * 修改房屋
     * 
     * @param zhongzHouse 房屋信息
     * @return 结果
     */
	public int updateZhongzHouse(ZhongzHouse zhongzHouse);

	/**
	 * 删除房屋（逻辑）
	 *
	 * @param id 房屋ID
	 * @return 结果
	 */
	public int deleteZhongzHouseById1(String id);

	/**
	 * 批量删除房屋（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzHouseByIds1(String[] ids);

	/**
     * 删除房屋
     * 
     * @param id 房屋ID
     * @return 结果
     */
	public int deleteZhongzHouseById(String id);
	
	/**
     * 批量删除房屋
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzHouseByIds(String[] ids);
	
}