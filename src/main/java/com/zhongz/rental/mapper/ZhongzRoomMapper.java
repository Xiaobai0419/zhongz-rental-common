package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房间 数据层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface ZhongzRoomMapper 
{
	/**
     * 查询房间信息
     * 
     * @param id 房间ID
     * @return 房间信息
     */
	public ZhongzRoom selectZhongzRoomById(String id);

	/**
	 * 查询指定房屋所有房间集合
	 *
	 * @param houseId 房屋ID
	 * @return 房间集合
	 */
	public List<ZhongzRoom> selectZhongzRoomByHouseId(@Param("houseId") String houseId);

	/**
     * 查询房间列表
     * 
     * @param zhongzRoom 房间信息
     * @return 房间集合
     */
	public List<ZhongzRoom> selectZhongzRoomList(ZhongzRoom zhongzRoom);

	/**
	 * 查询有未租房间的房子
	 *
	 * @return 房间集合
	 */
	public List<String> selectZhongzRoomList1();

	/**
     * 新增房间
     * 
     * @param zhongzRoom 房间信息
     * @return 结果
     */
	public int insertZhongzRoom(ZhongzRoom zhongzRoom);
	
	/**
     * 修改房间
     * 
     * @param zhongzRoom 房间信息
     * @return 结果
     */
	public int updateZhongzRoom(ZhongzRoom zhongzRoom);

	/**
	 * 删除房间（逻辑）
	 *
	 * @param id 房间ID
	 * @return 结果
	 */
	public int deleteZhongzRoomById1(String id);

	/**
	 * 批量删除房间（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzRoomByIds1(String[] ids);

	/**
     * 删除房间
     * 
     * @param id 房间ID
     * @return 结果
     */
	public int deleteZhongzRoomById(String id);
	
	/**
     * 批量删除房间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzRoomByIds(String[] ids);
	
}