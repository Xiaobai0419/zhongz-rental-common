package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzCouponPolicy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券策略 数据层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface ZhongzCouponPolicyMapper 
{
	/**
     * 查询优惠券策略信息
     * 
     * @param id 优惠券策略ID
     * @return 优惠券策略信息
     */
	public ZhongzCouponPolicy selectZhongzCouponPolicyById(String id);
	
	/**
     * 查询优惠券策略列表
     * 
     * @param zhongzCouponPolicy 优惠券策略信息
     * @return 优惠券策略集合
     */
	public List<ZhongzCouponPolicy> selectZhongzCouponPolicyList(ZhongzCouponPolicy zhongzCouponPolicy);
	
	/**
     * 新增优惠券策略
     * 
     * @param zhongzCouponPolicy 优惠券策略信息
     * @return 结果
     */
	public int insertZhongzCouponPolicy(ZhongzCouponPolicy zhongzCouponPolicy);
	
	/**
     * 修改优惠券策略
     * 
     * @param zhongzCouponPolicy 优惠券策略信息
     * @return 结果
     */
	public int updateZhongzCouponPolicy(ZhongzCouponPolicy zhongzCouponPolicy);

	/**
	 * 删除优惠券策略（逻辑）
	 *
	 * @param id 优惠券策略ID
	 * @return 结果
	 */
	public int deleteZhongzCouponPolicyById1(String id);

	/**
	 * 批量删除优惠券策略（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzCouponPolicyByIds1(String[] ids);

	/**
     * 删除优惠券策略
     * 
     * @param id 优惠券策略ID
     * @return 结果
     */
	public int deleteZhongzCouponPolicyById(String id);
	
	/**
     * 批量删除优惠券策略
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzCouponPolicyByIds(String[] ids);

	/**
	 * 按标题查询优惠券政策信息
	 * @param titile 标题
	 * @return
	 */
	public ZhongzCouponPolicy selectZhongzCouponPolicyByTitle(@Param("titile") String titile);
}