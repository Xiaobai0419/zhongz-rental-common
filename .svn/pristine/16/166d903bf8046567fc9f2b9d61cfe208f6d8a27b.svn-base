package com.zhongz.rental.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhongz.rental.domain.ZhongzCoupon;
import com.zhongz.rental.domain.ZhongzHouse;
import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.mapper.ZhongzCouponMapper;
import com.zhongz.rental.mapper.ZhongzHouseMapper;
import com.zhongz.rental.mapper.ZhongzUserMapper;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.result.base.Result;
import com.zhongz.rental.service.IZhongzCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 优惠券 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class ZhongzCouponServiceImpl implements IZhongzCouponService
{
	@Value("${redis.keys.user}")
	private String userKey;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private ZhongzUserMapper zhongzUserMapper;
	@Autowired
	private ZhongzCouponMapper zhongzCouponMapper;
	@Autowired
	private ZhongzHouseMapper zhongzHouseMapper;

	/**
     * 查询优惠券信息
     * 
     * @param id 优惠券ID
     * @return 优惠券信息
     */
    @Override
	public ZhongzCoupon selectZhongzCouponById(String id)
	{
	    return zhongzCouponMapper.selectZhongzCouponById(id);
	}
	
	/**
     * 查询优惠券列表
     * 
     * @param zhongzCoupon 优惠券信息
     * @return 优惠券集合
     */
	@Override
	public List<ZhongzCoupon> selectZhongzCouponList(ZhongzCoupon zhongzCoupon)
	{
	    return zhongzCouponMapper.selectZhongzCouponList(zhongzCoupon);
	}

	/**
	 * 查询用户已使用优惠券列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 优惠券集合
	 */
	@Override
	public Result<ZhongzCoupon> selectZhongzUserCouponUsedList(ZhongzUserOrderParam zhongzUserOrderParam)
	{
		zhongzUserOrderParam.genMysqlPage();
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		List<ZhongzCoupon> coupons = zhongzCouponMapper.selectZhongzUserCouponUsedList(user.getId(),null,null);
		Integer totalNum = coupons.size();
		if(totalNum == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),0,new ArrayList<>());
		}
		coupons = zhongzCouponMapper.selectZhongzUserCouponUsedList(user.getId(),zhongzUserOrderParam.getLimitStart(),zhongzUserOrderParam.getLimitNum());
		if(coupons.size() == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,new ArrayList<>());
		}
		if(coupons.size() > 0) {
			List<String> houseIds = new ArrayList<>();
			for(ZhongzCoupon coupon : coupons) {
				houseIds.add(coupon.getHouseId());
			}
			List<ZhongzHouse> houses = zhongzHouseMapper.selectZhongzHouseByIds(houseIds);
			Map<String,ZhongzHouse> houseMap = new HashMap<>();
			for(ZhongzHouse house : houses) {
				houseMap.put(house.getId(),house);
			}
			for(ZhongzCoupon coupon : coupons) {
				coupon.setHouse(houseMap.get(coupon.getHouseId()));
			}
		}
		return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,coupons);
	}

	/**
	 * 查询用户未使用优惠券列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 优惠券集合
	 */
	@Override
	public Result<ZhongzCoupon> selectZhongzUserCouponNotUsedList(ZhongzUserOrderParam zhongzUserOrderParam)
	{
		zhongzUserOrderParam.genMysqlPage();
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		List<ZhongzCoupon> coupons = zhongzCouponMapper.selectZhongzUserCouponNotUsedList(user.getId(),null,null);
		Integer totalNum = coupons.size();
		if(totalNum == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),0,new ArrayList<>());
		}
		coupons = zhongzCouponMapper.selectZhongzUserCouponNotUsedList(user.getId(),zhongzUserOrderParam.getLimitStart(),zhongzUserOrderParam.getLimitNum());
		if(coupons.size() == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,new ArrayList<>());
		}
		return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,coupons);
	}

	/**
	 * 查询用户已过期优惠券列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 优惠券集合
	 */
	@Override
	public Result<ZhongzCoupon> selectZhongzUserCouponExpiredList(ZhongzUserOrderParam zhongzUserOrderParam)
	{
		zhongzUserOrderParam.genMysqlPage();
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		List<ZhongzCoupon> coupons = zhongzCouponMapper.selectZhongzUserCouponExpiredList(user.getId(),null,null);
		Integer totalNum = coupons.size();
		if(totalNum == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),0,new ArrayList<>());
		}
		coupons = zhongzCouponMapper.selectZhongzUserCouponExpiredList(user.getId(),zhongzUserOrderParam.getLimitStart(),zhongzUserOrderParam.getLimitNum());
		if(coupons.size() == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,new ArrayList<>());
		}
		return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,coupons);
	}

    /**
     * 新增优惠券
     * 
     * @param zhongzCoupon 优惠券信息
     * @return 结果
     */
	@Override
	public int insertZhongzCoupon(ZhongzCoupon zhongzCoupon)
	{
	    return zhongzCouponMapper.insertZhongzCoupon(zhongzCoupon);
	}
	
	/**
     * 修改优惠券
     * 
     * @param zhongzCoupon 优惠券信息
     * @return 结果
     */
	@Override
	public int updateZhongzCoupon(ZhongzCoupon zhongzCoupon)
	{
	    return zhongzCouponMapper.updateZhongzCoupon(zhongzCoupon);
	}

	/**
     * 删除优惠券对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzCouponByIds(String ids)
	{
		return zhongzCouponMapper.deleteZhongzCouponByIds1(Convert.toStrArray(ids));
	}
	
}
