package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzCouponPolicy;
import com.zhongz.rental.mapper.ZhongzCouponPolicyMapper;
import com.zhongz.rental.service.IZhongzCouponPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 优惠券策略 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class ZhongzCouponPolicyServiceImpl implements IZhongzCouponPolicyService
{
	@Autowired
	private ZhongzCouponPolicyMapper zhongzCouponPolicyMapper;

	/**
     * 查询优惠券策略信息
     * 
     * @param id 优惠券策略ID
     * @return 优惠券策略信息
     */
    @Override
	public ZhongzCouponPolicy selectZhongzCouponPolicyById(String id)
	{
	    return zhongzCouponPolicyMapper.selectZhongzCouponPolicyById(id);
	}
	
	/**
     * 查询优惠券策略列表
     * 
     * @param zhongzCouponPolicy 优惠券策略信息
     * @return 优惠券策略集合
     */
	@Override
	public List<ZhongzCouponPolicy> selectZhongzCouponPolicyList(ZhongzCouponPolicy zhongzCouponPolicy)
	{
	    return zhongzCouponPolicyMapper.selectZhongzCouponPolicyList(zhongzCouponPolicy);
	}
	
    /**
     * 新增优惠券策略
     * 
     * @param zhongzCouponPolicy 优惠券策略信息
     * @return 结果
     */
	@Override
	public int insertZhongzCouponPolicy(ZhongzCouponPolicy zhongzCouponPolicy)
	{
	    return zhongzCouponPolicyMapper.insertZhongzCouponPolicy(zhongzCouponPolicy);
	}
	
	/**
     * 修改优惠券策略
     * 
     * @param zhongzCouponPolicy 优惠券策略信息
     * @return 结果
     */
	@Override
	public int updateZhongzCouponPolicy(ZhongzCouponPolicy zhongzCouponPolicy)
	{
	    return zhongzCouponPolicyMapper.updateZhongzCouponPolicy(zhongzCouponPolicy);
	}

	/**
     * 删除优惠券策略对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzCouponPolicyByIds(String ids)
	{
		return zhongzCouponPolicyMapper.deleteZhongzCouponPolicyByIds1(Convert.toStrArray(ids));
	}
	
}
