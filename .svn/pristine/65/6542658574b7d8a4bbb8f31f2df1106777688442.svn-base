package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzCoupon;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.result.base.Result;

import java.util.List;

/**
 * 优惠券 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IZhongzCouponService 
{
	/**
     * 查询优惠券信息
     * 
     * @param id 优惠券ID
     * @return 优惠券信息
     */
	public ZhongzCoupon selectZhongzCouponById(String id);
	
	/**
     * 查询优惠券列表
     * 
     * @param zhongzCoupon 优惠券信息
     * @return 优惠券集合
     */
	public List<ZhongzCoupon> selectZhongzCouponList(ZhongzCoupon zhongzCoupon);

	/**
	 * 查询用户已使用优惠券列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 优惠券集合
	 */
	public Result<ZhongzCoupon> selectZhongzUserCouponUsedList(ZhongzUserOrderParam zhongzUserOrderParam);


	/**
	 * 查询用户未使用优惠券列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 优惠券集合
	 */
	public Result<ZhongzCoupon> selectZhongzUserCouponNotUsedList(ZhongzUserOrderParam zhongzUserOrderParam);


	/**
	 * 查询用户已过期优惠券列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 优惠券集合
	 */
	public Result<ZhongzCoupon> selectZhongzUserCouponExpiredList(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
     * 新增优惠券
     * 
     * @param zhongzCoupon 优惠券信息
     * @return 结果
     */
	public int insertZhongzCoupon(ZhongzCoupon zhongzCoupon);
	
	/**
     * 修改优惠券
     * 
     * @param zhongzCoupon 优惠券信息
     * @return 结果
     */
	public int updateZhongzCoupon(ZhongzCoupon zhongzCoupon);
		
	/**
     * 删除优惠券信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzCouponByIds(String ids);
	
}
