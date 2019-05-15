package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzRoom;
import java.util.List;

/**
 * 房间 服务层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface IZhongzRoomService 
{
	/**
     * 查询房间信息
     * 
     * @param id 房间ID
     * @return 房间信息
     */
	public ZhongzRoom selectZhongzRoomById(String id);
	
	/**
     * 查询房间列表
     * 
     * @param zhongzRoom 房间信息
     * @return 房间集合
     */
	public List<ZhongzRoom> selectZhongzRoomList(ZhongzRoom zhongzRoom);

	/**
	 * 查询指定房屋所有房间集合
	 *
	 * @param houseId 房屋ID
	 * @return 房间集合
	 */
	public List<ZhongzRoom> selectZhongzRoomByHouseId(String houseId);

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
     * 删除房间信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzRoomByIds(String ids);
	
}
