package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单 数据层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface ZhongzOrderMapper 
{
	/**
     * 查询订单信息
     * 
     * @param id 订单ID
     * @return 订单信息
     */
	public ZhongzOrder selectZhongzOrderById(String id);

	/**
	 * 查询首租/续约订单日最大序号
	 *
	 * @return 订单信息
	 */
	public Integer selectZhongzOrderDayMaxOrder(@Param("orderType") Integer orderType);

	/**
     * 查询首租订单列表
     * 
     * @param zhongzOrder 订单信息
     * @return 订单集合
     */
	public List<ZhongzOrder> selectZhongzOrderList(ZhongzOrder zhongzOrder);

	/**
	 * 查询续约订单列表
	 *
	 * @param zhongzOrder 订单信息
	 * @return 订单集合
	 */
	public List<ZhongzOrder> selectZhongzOrderRenewList(ZhongzOrder zhongzOrder);

	/**
     * 新增订单
     * 
     * @param zhongzOrder 订单信息
     * @return 结果
     */
	public int insertZhongzOrder(ZhongzOrder zhongzOrder);
	
	/**
     * 修改订单
     * 
     * @param zhongzOrder 订单信息
     * @return 结果
     */
	public int updateZhongzOrder(ZhongzOrder zhongzOrder);

	/**
	 * 删除订单（批量）
	 *
	 * @param id 订单ID
	 * @return 结果
	 */
	public int deleteZhongzOrderById1(String id);

	/**
	 * 批量删除订单（批量）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzOrderByIds1(String[] ids);

	/**
     * 删除订单
     * 
     * @param id 订单ID
     * @return 结果
     */
	public int deleteZhongzOrderById(String id);
	
	/**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzOrderByIds(String[] ids);
	
}