package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzSuggestion;
import java.util.List;
import java.util.Map;

/**
 * 意见反馈 服务层
 * 
 * @author ruoyi
 * @date 2019-04-28
 */
public interface IZhongzSuggestionService 
{
	/**
     * 查询意见反馈信息
     * 
     * @param id 意见反馈ID
     * @return 意见反馈信息
     */
	public ZhongzSuggestion selectZhongzSuggestionById(String id);
	
	/**
     * 查询意见反馈列表
     * 
     * @param zhongzSuggestion 意见反馈信息
     * @return 意见反馈集合
     */
	public List<ZhongzSuggestion> selectZhongzSuggestionList(ZhongzSuggestion zhongzSuggestion);
	
	/**
     * 新增意见反馈
     * 
     * @param zhongzSuggestion 意见反馈信息
     * @return 结果
     */
	public int insertZhongzSuggestion(ZhongzSuggestion zhongzSuggestion);
	
	/**
     * 修改意见反馈
     * 
     * @param zhongzSuggestion 意见反馈信息
     * @return 结果
     */
	public int updateZhongzSuggestion(ZhongzSuggestion zhongzSuggestion);
		
	/**
     * 删除意见反馈信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzSuggestionByIds(String ids);
	
	public List<ZhongzSuggestion> selectZhongzSuggestionJoinUserList(ZhongzSuggestion zhongzSuggestion);
	
	public int updateZhongzSuggestionByIds(Map<String, Object> params, String ids);
	
}
