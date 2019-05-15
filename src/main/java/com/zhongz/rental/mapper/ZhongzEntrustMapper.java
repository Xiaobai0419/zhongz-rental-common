package com.zhongz.rental.mapper;

import java.util.List;
import java.util.Map;

import com.zhongz.rental.domain.ZhongzEntrust;	

/**
 * 业主委托 数据层
 * 
 * @author ruoyi
 * @date 2019-04-28
 */
public interface ZhongzEntrustMapper 
{
	/**
     * 查询业主委托信息
     * 
     * @param id 业主委托ID
     * @return 业主委托信息
     */
	public ZhongzEntrust selectZhongzEntrustById(String id);
	
	/**
     * 查询业主委托列表
     * 
     * @param zhongzEntrust 业主委托信息
     * @return 业主委托集合
     */
	public List<ZhongzEntrust> selectZhongzEntrustList(ZhongzEntrust zhongzEntrust);
	
	/**
     * 新增业主委托
     * 
     * @param zhongzEntrust 业主委托信息
     * @return 结果
     */
	public int insertZhongzEntrust(ZhongzEntrust zhongzEntrust);
	
	/**
     * 修改业主委托
     * 
     * @param zhongzEntrust 业主委托信息
     * @return 结果
     */
	public int updateZhongzEntrust(ZhongzEntrust zhongzEntrust);
	
	/**
     * 删除业主委托
     * 
     * @param id 业主委托ID
     * @return 结果
     */
	public int deleteZhongzEntrustById(String id);
	
	/**
     * 批量删除业主委托
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzEntrustByIds(String[] ids);
	
	public List<ZhongzEntrust> selectZhongzEntrustJoinUserList(ZhongzEntrust zhongzEntrust);
	
	public int updateZhongzEntrustByIds(Map<String, Object> params);
	
}