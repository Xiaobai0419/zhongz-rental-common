package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzManager;

import java.util.List;

/**
 * 管家 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IZhongzManagerService 
{
	/**
     * 查询管家信息
     * 
     * @param id 管家ID
     * @return 管家信息
     */
	public ZhongzManager selectZhongzManagerById(String id);

	/**
	 * 查询管家信息
	 *
	 * @return 管家信息
	 */
	public ZhongzManager selectZhongzManager();

	/**
     * 查询管家列表
     * 
     * @param zhongzManager 管家信息
     * @return 管家集合
     */
	public List<ZhongzManager> selectZhongzManagerList(ZhongzManager zhongzManager);
	
	/**
     * 新增管家
     * 
     * @param zhongzManager 管家信息
     * @return 结果
     */
	public int insertZhongzManager(ZhongzManager zhongzManager);
	
	/**
     * 修改管家
     * 
     * @param zhongzManager 管家信息
     * @return 结果
     */
	public int updateZhongzManager(ZhongzManager zhongzManager);
		
	/**
     * 删除管家信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzManagerByIds(String ids);
	
}
