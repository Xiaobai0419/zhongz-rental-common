package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzContract;
import com.zhongz.rental.domain.ZhongzOrder;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.result.base.Result;
import java.util.List;

/**
 * 订单 服务层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface IZhongzOrderService 
{
	/**
     * 查询订单信息
     * 
     * @param id 订单ID
     * @return 订单信息
     */
	public ZhongzContract selectZhongzOrderById(String id);
	
	/**
     * 查询首租订单列表
     * 
     * @param zhongzOrder 订单信息
     * @return 订单集合
     */
	public List<ZhongzOrder> selectZhongzOrderList(ZhongzOrder zhongzOrder);

	/**
	 * 查询续约订单列表 TODO 各种条件的搜索
	 *
	 * @param zhongzOrder 订单信息
	 * @return 订单集合
	 */
	public List<ZhongzOrder> selectZhongzOrderRenewList(ZhongzOrder zhongzOrder);

	/**
     * 新增订单
     * 
     * @param zhongzUserOrderParam 用户预约订单信息
     * @return 结果
     */
	public Result insertZhongzOrder(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
	 * 新增续约订单
	 *
	 * @param zhongzUserOrderParam 用户预约订单信息
	 * @return 结果
	 */
	public Result insertZhongzRenewOrder(ZhongzUserOrderParam zhongzUserOrderParam);
	
	/**
     * 修改订单
     * 
     * @param zhongzContract 订单信息
     * @return 结果
     */
	public int updateZhongzOrder(ZhongzContract zhongzContract);
		
	/**
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzOrderByIds(String ids);
	
}
