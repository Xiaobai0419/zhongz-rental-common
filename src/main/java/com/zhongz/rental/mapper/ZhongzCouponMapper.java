package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券 数据层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface ZhongzCouponMapper 
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
	 * 按券码查优惠券
	 *
	 * @param couponCode 优惠券码
	 * @return 优惠券集合
	 */
	public ZhongzCoupon selectByCouponCode(@Param("couponCode") String couponCode);

	/**
	 * 查询用户已使用优惠券列表
	 *
	 * @param userId 用户id
	 * @return 优惠券集合
	 */
	public List<ZhongzCoupon> selectZhongzUserCouponUsedList(@Param("userId") String userId, @Param("limitStart") Integer limitStart, @Param("limitNum") Integer limitNum);


	/**
	 * 查询用户未使用优惠券列表
	 *
	 * @param userId 用户id
	 * @return 优惠券集合
	 */
	public List<ZhongzCoupon> selectZhongzUserCouponNotUsedList(@Param("userId") String userId, @Param("limitStart") Integer limitStart, @Param("limitNum") Integer limitNum);


	/**
	 * 查询用户已过期优惠券列表
	 *
	 * @param userId 用户id
	 * @return 优惠券集合
	 */
	public List<ZhongzCoupon> selectZhongzUserCouponExpiredList(@Param("userId") String userId, @Param("limitStart") Integer limitStart, @Param("limitNum") Integer limitNum);

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
	 * 删除优惠券（逻辑）
	 *
	 * @param id 优惠券ID
	 * @return 结果
	 */
	public int deleteZhongzCouponById1(String id);

	/**
	 * 批量删除优惠券（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzCouponByIds1(String[] ids);

	/**
     * 删除优惠券
     * 
     * @param id 优惠券ID
     * @return 结果
     */
	public int deleteZhongzCouponById(String id);
	
	/**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzCouponByIds(String[] ids);
	
}