package com.zhongz.rental.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.mapper.ZhongzUserMapper;
import com.zhongz.rental.result.base.Result;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${redis.keys.user}")
    private String userKey;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private ZhongzUserMapper zhongzUserMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("-----------------------------------preHandle:请求前调用");
        Result result = new Result();
        //判断登录，查询用户信息
        String openid = request.getParameter("openid");
        String sessionKey = request.getParameter("sessionKey");
        if(StringUtils.isBlank(openid) || StringUtils.isBlank(sessionKey)) {
            result.setSuccess(false);
            result.setResultCode(410);
            result.setMessage("请先登录");
            //结果写入json字符串返回response
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSONObject.toJSONString(result));
            return false;
        }
        //判断登录态（可能sessionKey登录过期），每次登录过期小程序端会重新登录，同步sessionKey等信息到缓存和数据库
        //从Redis获取用户信息，没有降级去数据库获取
        HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
        ZhongzUser user = hashOperations.get(userKey,openid);
        if(user == null) {
            user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
        }
        if(user == null || !openid.equals(user.getOpenid()) || !sessionKey.equals(user.getSessionKey())) {
            result.setSuccess(false);
            result.setResultCode(411);
            result.setMessage("请重新登录");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSONObject.toJSONString(result));
            return false;
        }
        //返回 false 则请求中断
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}