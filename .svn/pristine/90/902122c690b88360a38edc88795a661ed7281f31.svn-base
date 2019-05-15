package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzEvent;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 活动 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IZhongzEventService 
{
	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
	public ZhongzEvent selectZhongzEventById(String id);

	/**
	 * 查询活动详情页
	 *
	 * @param id 活动ID
	 * @return 活动信息
	 */
	public String selectZhongzEvent(String id,String eventHousePageUrl, ModelMap mmap);

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
     * 删除活动信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzEventByIds(String ids);
	
}
