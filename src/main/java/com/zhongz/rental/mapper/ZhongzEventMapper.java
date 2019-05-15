package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzEvent;

import java.util.List;

/**
 * 活动 数据层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface ZhongzEventMapper 
{
	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
	public ZhongzEvent selectZhongzEventById(String id);
	
	/**
     * 查询活动列表
     * 
     * @param zhongzEvent 活动信息
     * @return 活动集合
     */
	public List<ZhongzEvent> selectZhongzEventList(ZhongzEvent zhongzEvent);

	/**
	 * 查询前端显示活动列表
	 *
	 * @return 活动集合
	 */
	public List<ZhongzEvent> selectZhongzEventsFrontEnd();

	/**
     * 新增活动
     * 
     * @param zhongzEvent 活动信息
     * @return 结果
     */
	public int insertZhongzEvent(ZhongzEvent zhongzEvent);
	
	/**
     * 修改活动
     * 
     * @param zhongzEvent 活动信息
     * @return 结果
     */
	public int updateZhongzEvent(ZhongzEvent zhongzEvent);

	/**
	 * 删除活动（逻辑）
	 *
	 * @param id 活动ID
	 * @return 结果
	 */
	public int deleteZhongzEventById1(String id);

	/**
	 * 批量删除活动（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzEventByIds1(String[] ids);

	/**
     * 删除活动
     * 
     * @param id 活动ID
     * @return 结果
     */
	public int deleteZhongzEventById(String id);
	
	/**
     * 批量删除活动
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzEventByIds(String[] ids);
	
}