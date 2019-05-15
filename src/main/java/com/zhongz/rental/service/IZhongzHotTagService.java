package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzHotTag;

import java.util.List;

/**
 * 热度标签类别 服务层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface IZhongzHotTagService 
{
	/**
     * 查询热度标签类别信息
     * 
     * @param id 热度标签类别ID
     * @return 热度标签类别信息
     */
	public ZhongzHotTag selectZhongzHotTagById(String id);
	
	/**
     * 查询热度标签类别列表
     * 
     * @param zhongzHotTag 热度标签类别信息
     * @return 热度标签类别集合
     */
	public List<ZhongzHotTag> selectZhongzHotTagList(ZhongzHotTag zhongzHotTag);

	/**
	 * 查询热度标签类别列表
	 *
	 * @return 热度标签类别集合
	 */
	public List<ZhongzHotTag> selectZhongzHotTagList();

	/**
     * 新增热度标签类别
     * 
     * @param zhongzHotTag 热度标签类别信息
     * @return 结果
     */
	public int insertZhongzHotTag(ZhongzHotTag zhongzHotTag);
	
	/**
     * 修改热度标签类别
     * 
     * @param zhongzHotTag 热度标签类别信息
     * @return 结果
     */
	public int updateZhongzHotTag(ZhongzHotTag zhongzHotTag);
		
	/**
     * 删除热度标签类别信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzHotTagByIds(String ids);
	
}
