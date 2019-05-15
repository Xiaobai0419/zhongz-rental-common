package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.common.utils.SmsSendUtils;
import com.zhongz.rental.domain.ZhongzComment;
import com.zhongz.rental.domain.ZhongzManager;
import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.mapper.ZhongzCommentMapper;
import com.zhongz.rental.mapper.ZhongzManagerMapper;
import com.zhongz.rental.mapper.ZhongzUserMapper;
import com.zhongz.rental.result.base.Result;
import com.zhongz.rental.service.IZhongzCommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 管家留言 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class ZhongzCommentServiceImpl implements IZhongzCommentService
{
	@Value("${redis.keys.user}")
	private String userKey;
	@Autowired
	private ZhongzUserMapper zhongzUserMapper;
	@Autowired
	private ZhongzCommentMapper zhongzCommentMapper;
	@Autowired
	private ZhongzManagerMapper zhongzManagerMapper;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	/**
     * 查询管家留言信息
     * 
     * @param id 管家留言ID
     * @return 管家留言信息
     */
    @Override
	public ZhongzComment selectZhongzCommentById(String id)
	{
	    return zhongzCommentMapper.selectZhongzCommentById(id);
	}
	
	/**
     * 查询管家留言列表
     * 
     * @param zhongzComment 管家留言信息
     * @return 管家留言集合
     */
	@Override
	public List<ZhongzComment> selectZhongzCommentList(ZhongzComment zhongzComment)
	{
	    return zhongzCommentMapper.selectZhongzCommentList(zhongzComment);
	}
	
    /**
     * 新增管家留言
     * 
     * @param zhongzComment 管家留言信息
     * @return 结果
     */
	@Override
	public Result insertZhongzComment(ZhongzComment zhongzComment)
	{
		Result result = new Result();
		if(StringUtils.isBlank(zhongzComment.getName())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入姓名");
			return result;
		}
		if(StringUtils.isBlank(zhongzComment.getMobile())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入手机号");
			return result;
		}
		if(StringUtils.isBlank(zhongzComment.getContent())) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入留言内容");
			return result;
		}
		//根据用户是否登录验证参数
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzComment.getOpenid();
		String sessionKey = zhongzComment.getSessionKey();
		if(StringUtils.isNotBlank(openid) && StringUtils.isNotBlank(sessionKey)) {
			HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
			ZhongzUser user = hashOperations.get(userKey,openid);
			if(user == null) {
				user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
			}
			zhongzComment.setMobile(user.getMobile());
			zhongzComment.setUserId(user.getId());
		}
		//发送短信给管家手机
		ZhongzManager manager = zhongzManagerMapper.selectZhongzManager();
		if(manager != null && StringUtils.isNotBlank(manager.getMobile())) {
			boolean smsR = SmsSendUtils.sendSms(manager.getMobile(),zhongzComment.getMobile(),
					zhongzComment.getName(),zhongzComment.getContent());
		}
		//入库
		zhongzComment.preInsert();
	    int ist = zhongzCommentMapper.insertZhongzComment(zhongzComment);
	    if(ist > 0) {
			result.setSuccess(true);
			result.setResultCode(200);
			result.setMessage("已发送留言到管家手机");
		}else {
			result.setSuccess(false);
			result.setResultCode(403);
			result.setMessage("留言失败");
		}
		return result;
	}
	
	/**
     * 修改管家留言
     * 
     * @param zhongzComment 管家留言信息
     * @return 结果
     */
	@Override
	public int updateZhongzComment(ZhongzComment zhongzComment)
	{
	    return zhongzCommentMapper.updateZhongzComment(zhongzComment);
	}

	/**
     * 删除管家留言对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzCommentByIds(String ids)
	{
		return zhongzCommentMapper.deleteZhongzCommentByIds1(Convert.toStrArray(ids));
	}
	
}
