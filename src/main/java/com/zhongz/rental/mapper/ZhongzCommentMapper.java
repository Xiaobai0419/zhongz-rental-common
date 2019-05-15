package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzComment;

import java.util.List;

/**
 * 管家留言 数据层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface ZhongzCommentMapper 
{
	/**
     * 查询管家留言信息
     * 
     * @param id 管家留言ID
     * @return 管家留言信息
     */
	public ZhongzComment selectZhongzCommentById(String id);
	
	/**
     * 查询管家留言列表
     * 
     * @param zhongzComment 管家留言信息
     * @return 管家留言集合
     */
	public List<ZhongzComment> selectZhongzCommentList(ZhongzComment zhongzComment);
	
	/**
     * 新增管家留言
     * 
     * @param zhongzComment 管家留言信息
     * @return 结果
     */
	public int insertZhongzComment(ZhongzComment zhongzComment);
	
	/**
     * 修改管家留言
     * 
     * @param zhongzComment 管家留言信息
     * @return 结果
     */
	public int updateZhongzComment(ZhongzComment zhongzComment);

	/**
	 * 删除管家留言（逻辑）
	 *
	 * @param id 管家留言ID
	 * @return 结果
	 */
	public int deleteZhongzCommentById1(String id);

	/**
	 * 批量删除管家留言（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzCommentByIds1(String[] ids);

	/**
     * 删除管家留言
     * 
     * @param id 管家留言ID
     * @return 结果
     */
	public int deleteZhongzCommentById(String id);
	
	/**
     * 批量删除管家留言
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzCommentByIds(String[] ids);
	
}