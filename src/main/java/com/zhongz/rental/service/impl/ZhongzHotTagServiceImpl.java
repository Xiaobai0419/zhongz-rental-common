package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzHotTag;
import com.zhongz.rental.mapper.ZhongzHotTagMapper;
import com.zhongz.rental.service.IZhongzHotTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 热度标签类别 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@Service
public class ZhongzHotTagServiceImpl implements IZhongzHotTagService
{
	@Autowired
	private ZhongzHotTagMapper zhongzHotTagMapper;

	/**
     * 查询热度标签类别信息
     * 
     * @param id 热度标签类别ID
     * @return 热度标签类别信息
     */
    @Override
	public ZhongzHotTag selectZhongzHotTagById(String id)
	{
	    return zhongzHotTagMapper.selectZhongzHotTagById(id);
	}
	
	/**
     * 查询热度标签类别列表
     * 
     * @param zhongzHotTag 热度标签类别信息
     * @return 热度标签类别集合
     */
	@Override
	public List<ZhongzHotTag> selectZhongzHotTagList(ZhongzHotTag zhongzHotTag)
	{
	    return zhongzHotTagMapper.selectZhongzHotTagList(zhongzHotTag);
	}

	/**
	 * 查询热度标签类别列表
	 *
	 * @return 热度标签类别集合
	 */
	@Override
	public List<ZhongzHotTag> selectZhongzHotTagList() {
		return zhongzHotTagMapper.selectZhongzHotTagAllList();
	}

    /**
     * 新增热度标签类别
     * 
     * @param zhongzHotTag 热度标签类别信息
     * @return 结果
     */
	@Override
	public int insertZhongzHotTag(ZhongzHotTag zhongzHotTag)
	{
	    return zhongzHotTagMapper.insertZhongzHotTag(zhongzHotTag);
	}
	
	/**
     * 修改热度标签类别
     * 
     * @param zhongzHotTag 热度标签类别信息
     * @return 结果
     */
	@Override
	public int updateZhongzHotTag(ZhongzHotTag zhongzHotTag)
	{
	    return zhongzHotTagMapper.updateZhongzHotTag(zhongzHotTag);
	}

	/**
     * 删除热度标签类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzHotTagByIds(String ids)
	{
		return zhongzHotTagMapper.deleteZhongzHotTagByIds1(Convert.toStrArray(ids));
	}
	
}
