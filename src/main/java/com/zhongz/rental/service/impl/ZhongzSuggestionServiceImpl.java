package com.zhongz.rental.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongz.rental.mapper.ZhongzSuggestionMapper;
import com.zhongz.rental.domain.ZhongzSuggestion;
import com.zhongz.rental.service.IZhongzSuggestionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 意见反馈 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-28
 */
@Service
public class ZhongzSuggestionServiceImpl implements IZhongzSuggestionService 
{
	@Autowired
	private ZhongzSuggestionMapper zhongzSuggestionMapper;

	/**
     * 查询意见反馈信息
     * 
     * @param id 意见反馈ID
     * @return 意见反馈信息
     */
    @Override
	public ZhongzSuggestion selectZhongzSuggestionById(String id)
	{
	    return zhongzSuggestionMapper.selectZhongzSuggestionById(id);
	}
	
	/**
     * 查询意见反馈列表
     * 
     * @param zhongzSuggestion 意见反馈信息
     * @return 意见反馈集合
     */
	@Override
	public List<ZhongzSuggestion> selectZhongzSuggestionList(ZhongzSuggestion zhongzSuggestion)
	{
	    return zhongzSuggestionMapper.selectZhongzSuggestionList(zhongzSuggestion);
	}
	
    /**
     * 新增意见反馈
     * 
     * @param zhongzSuggestion 意见反馈信息
     * @return 结果
     */
	@Override
	public int insertZhongzSuggestion(ZhongzSuggestion zhongzSuggestion)
	{
	    return zhongzSuggestionMapper.insertZhongzSuggestion(zhongzSuggestion);
	}
	
	/**
     * 修改意见反馈
     * 
     * @param zhongzSuggestion 意见反馈信息
     * @return 结果
     */
	@Override
	public int updateZhongzSuggestion(ZhongzSuggestion zhongzSuggestion)
	{
	    return zhongzSuggestionMapper.updateZhongzSuggestion(zhongzSuggestion);
	}

	/**
     * 删除意见反馈对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzSuggestionByIds(String ids)
	{
		return zhongzSuggestionMapper.deleteZhongzSuggestionByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ZhongzSuggestion> selectZhongzSuggestionJoinUserList(ZhongzSuggestion zhongzSuggestion) {
		return zhongzSuggestionMapper.selectZhongzSuggestionJoinUserList(zhongzSuggestion);
	}

	@Override
	public int updateZhongzSuggestionByIds(Map<String, Object> params, String ids) {
		params.put("ids", Convert.toStrArray(ids));
		return zhongzSuggestionMapper.updateZhongzSuggestionByIds(params);
	}
	
}
