package com.zhongz.rental.service.impl;

import com.zhongz.rental.common.utils.CodeGenUtils;
import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.mapper.ZhongzUserMapper;
import com.zhongz.rental.param.ZhongzPictureParam;
import com.zhongz.rental.result.PictureResult;
import com.zhongz.rental.service.IZhongzPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传业务图片 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class ZhongzPictureServiceImpl implements IZhongzPictureService
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
	private RedisTemplate<String,Object> redisTemplate;


    /**
     * 上传业务图片
     * 
     * @param zhongzPictureParam 业务图片信息
     * @return 结果
     */
	@Override
	public PictureResult uploadFile(MultipartFile file, ZhongzPictureParam zhongzPictureParam, HttpServletRequest request)
	{
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzPictureParam.getOpenid();
		String sessionKey = zhongzPictureParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		PictureResult result = new PictureResult();
		Integer business = zhongzPictureParam.getBusiness();
		if(business == null) {
			result.setSuccess(false);
			result.setResultCode(400);
			result.setMessage("请输入业务类型值");
			return result;
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
			result.setMessage("请上传文件");
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
			result.setMessage("文件上传失败");
			return result;
		}
		String folder = "";
		switch (business) {
			case 0:
				break;
			case 1:
				folder = "repairReportPics";
				break;
			case 2:
				folder = "cleaningReportPics";
				break;
			default:
				break;
		}
		File uploadDir = new File(rootPath.getAbsolutePath(),"images/upload/" + folder + "/" + user.getOpenid() + "/");
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
			result.setMessage("文件上传失败");
			return result;
		}
		String pictureUrl = webDomain + ":" + webPort + request.getServletContext().getContextPath() + "/images/upload/" + folder + "/" + user.getOpenid() + "/" + fileName;
		result.setUrl(pictureUrl);
		result.setSuccess(true);
		result.setResultCode(200);
		result.setMessage("文件上传成功");
		return result;
	}
}
