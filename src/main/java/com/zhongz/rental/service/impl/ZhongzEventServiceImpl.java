package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzEvent;
import com.zhongz.rental.mapper.ZhongzEventMapper;
import com.zhongz.rental.service.IZhongzEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 活动 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class ZhongzEventServiceImpl implements IZhongzEventService
{
	private String prefix = "zhongz/rental/event";

	@Autowired
	private ZhongzEventMapper zhongzEventMapper;

	/**
     * 查询活动信息
     * 
     * @param id 活动ID
     * @return 活动信息
     */
    @Override
	public ZhongzEvent selectZhongzEventById(String id)
	{
	    return zhongzEventMapper.selectZhongzEventById(id);
	}

	/**
	 * 查询活动详情页
	 *
	 * @param id 活动ID
	 * @return 活动信息
	 */
	@Override
	public String selectZhongzEvent(String id,String eventHousePageUrl, ModelMap mmap)
	{
		ZhongzEvent event = zhongzEventMapper.selectZhongzEventById(id);
		mmap.put("event",event);
		return prefix + "/single";
	}

	/**
     * 查询活动列表
     * 
     * @param zhongzEvent 活动信息
     * @return 活动集合
     */
	@Override
	public List<ZhongzEvent> selectZhongzEventList(ZhongzEvent zhongzEvent)
	{
	    return zhongzEventMapper.selectZhongzEventList(zhongzEvent);
	}

	/**
	 * 查询前端显示活动列表
	 *
	 * @return 活动集合
	 */
	@Override
	public List<ZhongzEvent> selectZhongzEventsFrontEnd() {
		return zhongzEventMapper.selectZhongzEventsFrontEnd();
	}

    /**
     * 新增活动
     * 
     * @param zhongzEvent 活动信息
     * @return 结果
     */
	@Override
	public int insertZhongzEvent(ZhongzEvent zhongzEvent)
	{
	    return zhongzEventMapper.insertZhongzEvent(zhongzEvent);
	}
	
	/**
     * 修改活动
     * 
     * @param zhongzEvent 活动信息
     * @return 结果
     */
	@Override
	public int updateZhongzEvent(ZhongzEvent zhongzEvent)
	{
	    return zhongzEventMapper.updateZhongzEvent(zhongzEvent);
	}

	/**
     * 删除活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzEventByIds(String ids)
	{
		return zhongzEventMapper.deleteZhongzEventByIds1(Convert.toStrArray(ids));
	}
	
}
