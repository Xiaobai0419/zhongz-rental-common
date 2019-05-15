package com.zhongz.rental.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhongz.rental.common.utils.CodeGenUtils;
import com.zhongz.rental.common.utils.OrderUtils;
import com.zhongz.rental.domain.ZhongzContract;
import com.zhongz.rental.domain.ZhongzHouse;
import com.zhongz.rental.domain.ZhongzServiceOrder;
import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.mapper.ZhongzContractMapper;
import com.zhongz.rental.mapper.ZhongzHouseMapper;
import com.zhongz.rental.mapper.ZhongzServiceOrderMapper;
import com.zhongz.rental.mapper.ZhongzUserMapper;
import com.zhongz.rental.param.ZhongzUserServiceOrderParam;
import com.zhongz.rental.param.ZhongzUserServiceOrderWechatPayParam;
import com.zhongz.rental.result.ServiceOrderResult;
import com.zhongz.rental.result.base.Result;
import com.zhongz.rental.service.IZhongzServiceOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务订单 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
@Service
public class ZhongzServiceOrderServiceImpl implements IZhongzServiceOrderService
{
	@Value("${redis.keys.user}")
	private String userKey;
	@Value("${web.upload-path}")
	private String uploadPath;
	@Value("${web.domain}")
	private String webDomain;
	@Value("${web.port}")
	private Integer webPort;
	@Autowired
	private ZhongzUserMapper zhongzUserMapper;
	@Autowired
	private ZhongzContractMapper zhongzContractMapper;
	@Autowired
	private ZhongzServiceOrderMapper zhongzServiceOrderMapper;
	@Autowired
	private ZhongzHouseMapper zhongzHouseMapper;
	@Autowired
	private OrderUtils orderUtils;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	/**
     * 查询服务订单信息详情
     * 
     * @param id 服务订单ID
     * @return 服务订单信息
     */
    @Override
	public ServiceOrderResult selectZhongzServiceOrderById(String id)
	{
		ServiceOrderResult result = new ServiceOrderResult();
		if(StringUtils.isBlank(id)) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("缺少服务id信息");
			return result;
		}
		ZhongzServiceOrder serviceOrder = zhongzServiceOrderMapper.selectZhongzServiceOrderById(id);
		if(serviceOrder != null) {
			ZhongzHouse house = zhongzHouseMapper.selectZhongzHouseById(serviceOrder.getHouseId());
			serviceOrder.setHouse(house);
			result.setServiceOrder(serviceOrder);
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("获取成功");
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("未查到服务信息");
		}
		return result;
	}
	
	/**
     * 查询服务订单列表
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 服务订单集合
     */
	@Override
	public List<ZhongzServiceOrder> selectZhongzServiceOrderList(ZhongzServiceOrder zhongzServiceOrder)
	{
	    return zhongzServiceOrderMapper.selectZhongzServiceOrderList(zhongzServiceOrder);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairList(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairList(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairList(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus0(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setOrderStatus(0);
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairListByStatus(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairListByStatus(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已预约报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus1(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setOrderStatus(1);
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairListByStatus(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairListByStatus(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已完成报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus2(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setOrderStatus(2);
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairListByStatus(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserRepairListByStatus(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningList(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningList(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningList(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已下单保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus0(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setOrderStatus(0);
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningListByStatus(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningListByStatus(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已预约保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus1(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setOrderStatus(1);
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningListByStatus(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningListByStatus(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已完成保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	@Override
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus2(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		zhongzUserServiceOrderParam.setTenantId(user.getId());
		zhongzUserServiceOrderParam.setOrderStatus(2);
		zhongzUserServiceOrderParam.setLimitStart(null);
		zhongzUserServiceOrderParam.setLimitNum(null);
		List<ZhongzServiceOrder> list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningListByStatus(zhongzUserServiceOrderParam);
		if(list == null || list.size() == 0) {
			return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),0,new ArrayList<>());
		}
		Integer total = list.size();
		zhongzUserServiceOrderParam.genMysqlPage();
		list = zhongzServiceOrderMapper.selectZhongzServiceOrderUserCleaningListByStatus(zhongzUserServiceOrderParam);
		return new Result<>(zhongzUserServiceOrderParam.getPageNum(),zhongzUserServiceOrderParam.getPageSize(),total,list);
	}

    /**
     * 新增报修服务订单
     * 
     * @param zhongzUserServiceOrderParam 服务订单信息
     * @return 结果
     */
	@Override
	public Result insertZhongzServiceOrder(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam, HttpServletRequest request)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		Result result = new Result();
		//参数校验和数据库业务数据存在性校验
		if(StringUtils.isBlank(zhongzUserServiceOrderParam.getHouseId())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请选择报修房屋");
			return result;
		}
		//查询用户选择房屋对应的最新租期内有效签约合同（可能是首租可能是续租）
		ZhongzContract latestContract = zhongzContractMapper.selectZhongzLatestContractByUserAndHouse(user.getId(),zhongzUserServiceOrderParam.getHouseId());
		if(latestContract == null) {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("您没有该房屋的租期内合同");
			return result;
		}
//		Integer handlingServiceOrder = zhongzServiceOrderMapper.selectZhongzServiceOrderByUserHouseAndType(user.getId(),zhongzUserServiceOrderParam.getHouseId(),0);
//		if(handlingServiceOrder > 0) {
//			result.setSuccess(false);
//			result.setResultCode(403);
//			result.setMessage("您尚有未完成报修订单");
//			return result;
//		}
		if(zhongzUserServiceOrderParam.getRequestServiceType() == null) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请选择报修类型");
			return result;
		}
		if(StringUtils.isBlank(zhongzUserServiceOrderParam.getServiceDescription())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入报修内容");
			return result;
		}
		//生成订单号
		ZhongzServiceOrder zhongzServiceOrder = orderUtils.generateServiceOrder("BXDD",0);
		zhongzServiceOrder.preInsert();
		zhongzServiceOrder.setOrderStatus(0);
		zhongzServiceOrder.setOrderTime(new Date());
		zhongzServiceOrder.setHouseId(zhongzUserServiceOrderParam.getHouseId());
		zhongzServiceOrder.setRequestServiceType(zhongzUserServiceOrderParam.getRequestServiceType());
		zhongzServiceOrder.setServiceDescription(zhongzUserServiceOrderParam.getServiceDescription());
		//设置用户信息
		zhongzServiceOrder.setTenantId(user.getId());
		//获取该房子合同对应用户真实姓名和手机号
		zhongzServiceOrder.setName(latestContract.getName());
		zhongzServiceOrder.setMobile(latestContract.getMobile());
		String pictureUrls = zhongzUserServiceOrderParam.getPictures();
		if(StringUtils.isNotBlank(pictureUrls) && !"null".equals(pictureUrls) && !"undefined".equals(pictureUrls)) {
			zhongzServiceOrder.setPictures(pictureUrls);
		}
	    int res = zhongzServiceOrderMapper.insertZhongzServiceOrder(zhongzServiceOrder);
		if(res > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("报修提交成功");
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("报修提交失败");
		}
		return result;
	}

	/**
	 * 新增保洁服务订单
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 结果
	 */
	@Override
	public Result insertZhongzServiceCleaningOrder(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam, HttpServletRequest request)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		Result result = new Result();
		//参数校验和数据库业务数据存在性校验
		if(StringUtils.isBlank(zhongzUserServiceOrderParam.getHouseId())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请选择保洁房屋");
			return result;
		}
		//查询用户选择房屋对应的最新租期内有效签约合同（可能是首租可能是续租）
		ZhongzContract latestContract = zhongzContractMapper.selectZhongzLatestContractByUserAndHouse(user.getId(),zhongzUserServiceOrderParam.getHouseId());
		if(latestContract == null) {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("您没有该房屋的租期内合同");
			return result;
		}
//		Integer handlingServiceOrder = zhongzServiceOrderMapper.selectZhongzServiceOrderByUserHouseAndType(user.getId(),zhongzUserServiceOrderParam.getHouseId(),1);
//		if(handlingServiceOrder > 0) {
//			result.setSuccess(false);
//			result.setResultCode(403);
//			result.setMessage("您尚有未完成保洁订单");
//			return result;
//		}
		if(zhongzUserServiceOrderParam.getRequestServiceType() == null) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请选择保洁类型");
			return result;
		}
		if(StringUtils.isBlank(zhongzUserServiceOrderParam.getServiceDescription())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入保洁内容");
			return result;
		}
		//生成订单号
		ZhongzServiceOrder zhongzServiceOrder = orderUtils.generateServiceOrder("BJDD",1);
		zhongzServiceOrder.preInsert();
		zhongzServiceOrder.setOrderType(1);
		zhongzServiceOrder.setOrderStatus(0);
		zhongzServiceOrder.setOrderTime(new Date());
		zhongzServiceOrder.setHouseId(zhongzUserServiceOrderParam.getHouseId());
		zhongzServiceOrder.setRequestServiceType(zhongzUserServiceOrderParam.getRequestServiceType());
		zhongzServiceOrder.setServiceDescription(zhongzUserServiceOrderParam.getServiceDescription());
		//设置用户信息
		zhongzServiceOrder.setTenantId(user.getId());
		//获取该房子合同对应用户真实姓名和手机号
		zhongzServiceOrder.setName(latestContract.getName());
		zhongzServiceOrder.setMobile(latestContract.getMobile());
		String pictureUrls = zhongzUserServiceOrderParam.getPictures();
		if(StringUtils.isNotBlank(pictureUrls) && !"null".equals(pictureUrls) && !"undefined".equals(pictureUrls)) {
			zhongzServiceOrder.setPictures(pictureUrls);
		}
		int res = zhongzServiceOrderMapper.insertZhongzServiceOrder(zhongzServiceOrder);
		if(res > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("保洁提交成功");
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("保洁提交失败");
		}
		return result;
	}

	/**
	 * 服务订单微信支付
	 *
	 * @param zhongzUserServiceOrderWechatPayParam 服务订单信息
	 * @return 结果
	 */
	@Override
	public Result wechatPayZhongzServiceOrder(ZhongzUserServiceOrderWechatPayParam zhongzUserServiceOrderWechatPayParam)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserServiceOrderWechatPayParam.getOpenid();
		String sessionKey = zhongzUserServiceOrderWechatPayParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		Result result = new Result();
		//根据订单id查询订单信息
		String id = zhongzUserServiceOrderWechatPayParam.getId();
		if(StringUtils.isBlank(id) || "null".equals(id) || "undefined".equals(id)) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("缺少订单id信息");
			return result;
		}
		ZhongzServiceOrder serviceOrder = zhongzServiceOrderMapper.selectZhongzServiceOrderById(id);
		if(serviceOrder == null) {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("未查到订单信息");
			return result;
		}
		//调用微信支付接口生成预支付订单和相关信息返回

		//更新数据库


		return result;
	}

	/**
     * 修改服务订单
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 结果
     */
	@Override
	public int updateZhongzServiceOrder(ZhongzServiceOrder zhongzServiceOrder)
	{
	    return zhongzServiceOrderMapper.updateZhongzServiceOrder(zhongzServiceOrder);
	}

	/**
	 * 取消服务订单
	 *
	 * @param id 服务订单ID
	 * @return 结果
	 */
	@Override
	public Result cancelZhongzServiceOrder(String id)
	{
		Result result = new Result();
		if(StringUtils.isBlank(id)) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("缺少服务id信息");
			return result;
		}
		int res = zhongzServiceOrderMapper.cancelZhongzServiceOrder(id);
		if(res > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("取消订单成功");
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("取消订单失败");
		}
		return result;
	}

	/**
     * 删除服务订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzServiceOrderByIds(String ids)
	{
		return zhongzServiceOrderMapper.deleteZhongzServiceOrderByIds1(Convert.toStrArray(ids));
	}
	
}
