package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.param.ZhongzUserParam;
import com.zhongz.rental.result.LoginResult;
import com.zhongz.rental.result.base.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户 服务层
 * 
 * @author ruoyi
 * @date 2019-04-15
 */
public interface IZhongzUserService 
{
	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public ZhongzUser selectZhongzUserById(String id);

	/**
	 * 用户登录
	 *
	 * @param zhongzUserParam 用户信息参数
	 * @return 用户信息
	 */
	public LoginResult zhongzUserLogin(ZhongzUserParam zhongzUserParam);

	/**
	 * 用户登出
	 * @param zhongzUserOrderParam
	 * @return
	 */
	public LoginResult zhongzUserLogout(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
	 * 查询老带新已邀请用户列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 用户集合
	 */
	public Result<ZhongzUser> selectZhongzUserInvitedList(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
     * 查询用户列表
     * 
     * @param zhongzUser 用户信息
     * @return 用户集合
     */
	public List<ZhongzUser> selectZhongzUserList(ZhongzUser zhongzUser);
	
	/**
     * 新增用户
     * 
     * @param zhongzUser 用户信息
     * @return 结果
     */
	public int insertZhongzUser(ZhongzUser zhongzUser);
	
	/**
     * 修改用户
     * 
     * @param zhongzUser 用户信息
     * @return 结果
     */
	public int updateZhongzUser(ZhongzUser zhongzUser);

	/**
	 * 修改用户昵称
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 结果
	 */
	public LoginResult updateZhongzUserNickName(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
	 * 修改用户头像（上传文件并保存项目本地目录，并将生成的静态地址入库，需要配置工程静态Web资源）
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 结果
	 */
	public LoginResult updateZhongzUserHeadPortrait(MultipartFile file, ZhongzUserOrderParam zhongzUserOrderParam, HttpServletRequest request);

	/**
     * 删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzUserByIds(String ids);
	
}
