package com.zhongz.rental.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.zhongz.rental.common.utils.CodeGenUtils;
import com.zhongz.rental.common.utils.HttpClientUtils;
import com.zhongz.rental.domain.ZhongzCoupon;
import com.zhongz.rental.domain.ZhongzCouponPolicy;
import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.domain.ZhongzValidateCode;
import com.zhongz.rental.mapper.ZhongzCouponMapper;
import com.zhongz.rental.mapper.ZhongzCouponPolicyMapper;
import com.zhongz.rental.mapper.ZhongzUserMapper;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.param.ZhongzUserParam;
import com.zhongz.rental.result.LoginResult;
import com.zhongz.rental.result.base.Result;
import com.zhongz.rental.returnParam.ZhongzUserInvitedReturnParam;
import com.zhongz.rental.service.IZhongzUserService;
import com.zhongz.rental.service.IZhongzValidateCodeService;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-15
 */
@Log
@Service
public class ZhongzUserServiceImpl implements IZhongzUserService
{
	@Value("${wechat.AppID}")
	private String appID;
	@Value("${wechat.AppSecret}")
	private String appSecret;
    @Value("${wechat.httpsUrl}")
    private String httpsUrl;
    @Value("${wechat.grantType}")
    private String grantType;
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
	private ZhongzCouponMapper zhongzCouponMapper;
	@Autowired
	private ZhongzCouponPolicyMapper zhongzCouponPolicyMapper;
	@Autowired
	private IZhongzValidateCodeService zhongzValidateCodeService;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
	public ZhongzUser selectZhongzUserById(String id)
	{
	    return zhongzUserMapper.selectZhongzUserById(id);
	}

	/**
	 * 用户登录（微信授权登录、手机号登录）
	 *
	 * @param zhongzUserParam 用户信息参数
	 * @return 用户信息
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
	@Override
	public LoginResult zhongzUserLogin(ZhongzUserParam zhongzUserParam)
	{
		LoginResult result = new LoginResult();
		//判断是否有前台wx.login()后带过来的用户唯一授权code信息,没有，返回，提示缺少登录授权信息
		String wx_code = zhongzUserParam.getCode();
		String mobile = zhongzUserParam.getMobile();
		String validateCode = zhongzUserParam.getValidateCode();
		if(StringUtils.isBlank(wx_code)) {
			result.setSuccess(false);
			result.setResultCode(401);
			result.setMessage("缺少小程序登录凭证code");
			return result;
		}
		//判断如果是手机登录，是否有验证码--手机号登录和微信登录（不需要手机号）放在了一起，手机号登录前端需要判断手机号不能为空，否则空号仍可通过微信授权信息成功登录
		if(StringUtils.isNotBlank(mobile) && StringUtils.isBlank(validateCode)) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("手机登录缺少验证码");
			return result;
		}else if(StringUtils.isNotBlank(mobile)) {
			//验证验证码，失败返回验证码错误
			ZhongzValidateCode zhongzValidateCode = new ZhongzValidateCode();
			zhongzValidateCode.setMobile(mobile);
			zhongzValidateCode.setCode(validateCode);
			Result validateResult = zhongzValidateCodeService.selectZhongzValidateCode(zhongzValidateCode);
			if(validateResult == null || !validateResult.getSuccess()) {
				result.setSuccess(false);
				result.setResultCode(400);
				result.setMessage("验证码错误");
				return result;
			}
		}
		//使用code调用微信小程序登录流程，获取openid,查询是否有此openid用户，有，判断是否传递手机号，有，更新手机号，登录成功
		String httpsUrl = this.httpsUrl;
		Map<String, String> params = new HashMap<>();
		params.put("appid", appID);
		params.put("secret", appSecret);
		params.put("js_code", wx_code);
		params.put("grant_type", grantType);
		Map<String, String> header = new HashMap<>();
		String openId = null;
		String sessionKey = null;
		try {
			String resultString = HttpClientUtils.doGetRequest(httpsUrl, header, params);
			openId = (String) JSONObject.parseObject(resultString).get("openid");
			sessionKey = (String) JSONObject.parseObject(resultString).get("session_key");
		}catch (Exception e) {
			log.info("微信小程序服务端错误");
			e.printStackTrace();
		}
		if(StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)) {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("无法获取用户微信登录授权信息");
			return result;
		}
		ZhongzUser zhongzUser = new ZhongzUser();
		zhongzUser.setOpenid(openId);
		//每次更新会话秘钥
		zhongzUser.setSessionKey(sessionKey);
		//判断是否传递手机号，有，同步插入手机号，注册、登录成功
		if(StringUtils.isNotBlank(mobile)) {
			zhongzUser.setMobile(mobile);
		}
		//保存微信用户相关信息
		zhongzUser.setCountry(zhongzUserParam.getCountry());
		zhongzUser.setProvince(zhongzUserParam.getProvince());
		zhongzUser.setCity(zhongzUserParam.getCity());
		zhongzUser.setLanguage(zhongzUserParam.getLanguage());
		zhongzUser.setLongitude(zhongzUserParam.getLongitude());
		zhongzUser.setLatitude(zhongzUserParam.getLatitude());
		ZhongzUser user = zhongzUserMapper.selectZhongzUserByOpenId(openId);
		if(user != null) {
			zhongzUser.preUpdate();
			//更新登录时间
			zhongzUser.setLastLoginTime(new Date());
			zhongzUserMapper.updateZhongzUserByOpenId(zhongzUser);
		}
		//无此openid用户，注册插入
		else {
			zhongzUser.preInsert();
			//首次登录获取用户微信头像和昵称
			zhongzUser.setNickName(zhongzUserParam.getNickName());
			zhongzUser.setHeadPortrait(zhongzUserParam.getHeadPortrait());
			//设置用户唯一邀请码，保证唯一，按新生成的邀请码循环查询重复者，直到没有重复者
			String invitationCode = null;
			while (true) {
				invitationCode = CodeGenUtils.genRandomCode();
				ZhongzUser anoUser = zhongzUserMapper.selectZhongzUserByInvitationCode(invitationCode);
				if(anoUser == null) {
					break;
				}
			}
			zhongzUser.setInvitationCode(invitationCode);
			//首次登录（注册），如有邀请人，设置邀请人
			String invitor_code = zhongzUserParam.getInvitationCode();
			//传递了错误的邀请码，如果没有对应邀请人，会影响邀请列表和老带新优惠券业务，所以要判断，但不会造成无法注册，用户可以选择不传递邀请码的普通注册
			if(StringUtils.isNotBlank(invitor_code) && !"null".equals(invitor_code)
			&& !"undefined".equals(invitor_code)) {
				//这是邀请人
				ZhongzUser invitor = zhongzUserMapper.selectZhongzUserByInvitationCode(invitor_code);
				if(invitor == null) {
					result.setSuccess(false);
					result.setResultCode(403);
					result.setMessage("无法获取邀请人信息");
					return result;
				}
				zhongzUser.setInvitorId(invitor.getId());
			}
			//为该用户生成一张新用户欢迎礼优惠券，保证不重复，关联优惠券政策表，冗余政策字段，插入优惠券表
			String couponCode = null;
			while (true) {
				couponCode = CodeGenUtils.genRandomCode();
				ZhongzCoupon anoCoupon = zhongzCouponMapper.selectByCouponCode(couponCode);
				if(anoCoupon == null) {
					break;
				}
			}
			ZhongzCoupon coupon = new ZhongzCoupon();
			coupon.preInsert();
			coupon.setCode(couponCode);
			coupon.setAchieveTime(new Date());
			//设置该优惠券用户为准备注册的用户
			coupon.setUserId(zhongzUser.getId());
			//按“新用户欢迎礼”查询优惠券政策信息进行当时政策的存储
			String titile = "新用户欢迎礼";
			coupon.setTitile(titile);
			ZhongzCouponPolicy zhongzCouponPolicy = zhongzCouponPolicyMapper.selectZhongzCouponPolicyByTitle(titile);
			//需要后台提前维护对应优惠券政策信息，但即使没有这个信息也不能影响注册，只是优惠券缺少政策信息
			if(zhongzCouponPolicy != null) {
				coupon.setPolicyId(zhongzCouponPolicy.getId());
				coupon.setName(zhongzCouponPolicy.getName());
				coupon.setPreference(zhongzCouponPolicy.getPreference());
				coupon.setRules(zhongzCouponPolicy.getRules());
				coupon.setExpire(zhongzCouponPolicy.getExpire());
			}
			//该用户的“新用户欢迎礼”优惠券插入优惠券表
			zhongzCouponMapper.insertZhongzCoupon(coupon);
			//更新注册时间
			zhongzUser.setRegisterTime(new Date());
			//更新登录时间
			zhongzUser.setLastLoginTime(new Date());
			zhongzUserMapper.insertZhongzUser(zhongzUser);
		}
		//返回更新的用户信息，包括openid，新的会话秘钥等信息用于登录后的新会话
		user = zhongzUserMapper.selectZhongzUserByOpenId(openId);
		//渲染要求：无手机号的返回空串
		if(user.getMobile() == null) {
			user.setMobile("");
		}
		//以openid为key将用户信息存入缓存
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		hashOperations.put(userKey,user.getOpenid(),user);
		result.setSuccess(true);
		result.setResultCode(200);
		result.setMessage("登录成功");
		result.setUser(user);
		return result;
	}

	/**
	 * 用户登出
	 * @param zhongzUserOrderParam
	 * @return
	 */
	@Override
	public LoginResult zhongzUserLogout(ZhongzUserOrderParam zhongzUserOrderParam) {
		LoginResult result = new LoginResult();
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		if(user == null) {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("找不到用户");
			return result;
		}
		int upd = zhongzUserMapper.updateZhongzUserLogoutTime(zhongzUserOrderParam);
		if(upd > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("您已退出登录");
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("操作失败");
		}
		return result;
	}

	/**
	 * 查询老带新已邀请用户列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 用户集合
	 */
	@Override
	public Result<ZhongzUser> selectZhongzUserInvitedList(ZhongzUserOrderParam zhongzUserOrderParam)
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
		//查询已邀请及已签约用户信息--按已签约（签约时间）、已邀请（注册时间）排序的有序列表
		List<ZhongzUserInvitedReturnParam> userContractIds = zhongzUserMapper.selectZhongzUserInvitedList(user.getId(),user.getInvitationCode(),null,null);
		Integer totalNum = userContractIds.size();
		if(totalNum == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),0,new ArrayList<>());
		}
		userContractIds = zhongzUserMapper.selectZhongzUserInvitedList(user.getId(),user.getInvitationCode(),zhongzUserOrderParam.getLimitStart(),zhongzUserOrderParam.getLimitNum());
		if(userContractIds.size() == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,new ArrayList<>());
		}
		//按业务顺序的有序集合
		List<String> userIds = new ArrayList<>();
		Map<String,String> paramMap = new HashMap<>();
		for(ZhongzUserInvitedReturnParam param : userContractIds) {
			//有序去重：集合已按特定业务要求排序，且可能有重复用户，因sql使用distinct空集时会异常，不使用则同一个被邀请用户可能有多个房子的首租签约合同，Set集合则会导致乱序
			if(!userIds.contains(param.getId())) {
				userIds.add(param.getId());
			}
			//一个被邀约用户多个有效签约合同，自动覆盖成一个
			paramMap.put(param.getId(),param.getCid());
		}
		//批量查询用户
		List<ZhongzUser> users = zhongzUserMapper.selectZhongzUserByIds(userIds);
		//保持按上述顺序返回
		Map<String,ZhongzUser> userMap = new HashMap<>();
		for(ZhongzUser zhongzUser : users) {
			if(StringUtils.isNotBlank(paramMap.get(zhongzUser.getId()))) {
				//被邀请人有至少一个签约有效合同
				zhongzUser.setInvitedSigned(1);
			}
			userMap.put(zhongzUser.getId(),zhongzUser);
		}
		//有序集合，按插入顺序
		List<ZhongzUser> sortedUsers = new ArrayList<>();
		for(String userId : userIds) {
			sortedUsers.add(userMap.get(userId));
		}
		return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,sortedUsers);
	}

	/**
     * 查询用户列表
     * 
     * @param zhongzUser 用户信息
     * @return 用户集合
     */
	@Override
	public List<ZhongzUser> selectZhongzUserList(ZhongzUser zhongzUser)
	{
	    return zhongzUserMapper.selectZhongzUserList(zhongzUser);
	}
	
    /**
     * 新增用户
     * 
     * @param zhongzUser 用户信息
     * @return 结果
     */
	@Override
	public int insertZhongzUser(ZhongzUser zhongzUser)
	{
	    return zhongzUserMapper.insertZhongzUser(zhongzUser);
	}
	
	/**
     * 修改用户
     * 
     * @param zhongzUser 用户信息
     * @return 结果
     */
	@Override
	public int updateZhongzUser(ZhongzUser zhongzUser)
	{
	    return zhongzUserMapper.updateZhongzUser(zhongzUser);
	}

	/**
	 * 修改用户昵称
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 结果
	 */
	@Override
	public LoginResult updateZhongzUserNickName(ZhongzUserOrderParam zhongzUserOrderParam)
	{
		LoginResult result = new LoginResult();
		if(StringUtils.isBlank(zhongzUserOrderParam.getNickName())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入昵称");
			return result;
		}
		int upd = zhongzUserMapper.updateZhongzUserNickName(zhongzUserOrderParam);
		if(upd > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("修改成功");
			//返回更新的用户信息，包括昵称
			ZhongzUser user = zhongzUserMapper.selectZhongzUserByOpenId(zhongzUserOrderParam.getOpenid());
			//以openid为key将用户信息更新入缓存
			HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
			hashOperations.put(userKey,user.getOpenid(),user);
			result.setUser(user);
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("修改失败");
		}
		return result;
	}

	/**
	 * 修改用户头像（上传文件并保存项目本地目录，并将生成的静态地址入库，需要配置工程静态Web资源）
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 结果
	 */
	@Override
	public LoginResult updateZhongzUserHeadPortrait(MultipartFile file, ZhongzUserOrderParam zhongzUserOrderParam, HttpServletRequest request)
	{
		LoginResult result = new LoginResult();
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(file == null || inputStream == null) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请上传头像");
			return result;
		}
		//文件上传本地，生成静态地址入库
		File rootPath = null;
		try {
//			rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
			rootPath = new File(uploadPath);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("头像上传失败");
			return result;
		}
		File uploadDir = new File(rootPath.getAbsolutePath(),"images/upload/headPortrait/" + user.getOpenid() + "/");
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		//带随机性和时间戳的特征文件名
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		String fileName = format.format(new Date()) + CodeGenUtils.genRandomCode() + file.getOriginalFilename();
		File uploadPath = new File(uploadDir.getAbsolutePath(),fileName);
		try {
			file.transferTo(uploadPath);
		} catch (IOException e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("头像上传失败");
			return result;
		}
		String headPortrait = webDomain + ":" + webPort + request.getServletContext().getContextPath() + "/images/upload/headPortrait/" + user.getOpenid() + "/" + fileName;
		zhongzUserOrderParam.setHeadPortrait(headPortrait);
		int upd = zhongzUserMapper.updateZhongzUserHeadPortrait(zhongzUserOrderParam);
		if(upd > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("修改成功");
			//返回更新的用户信息，包括头像url
			user = zhongzUserMapper.selectZhongzUserByOpenId(zhongzUserOrderParam.getOpenid());
			//以openid为key将用户信息更新入缓存
			hashOperations.put(userKey,user.getOpenid(),user);
			result.setUser(user);
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("修改失败");
		}
		return result;
	}

	/**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzUserByIds(String ids)
	{
		return zhongzUserMapper.deleteZhongzUserByIds1(Convert.toStrArray(ids));
	}
	
}
