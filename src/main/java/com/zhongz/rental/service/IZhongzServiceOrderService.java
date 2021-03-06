package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzServiceOrder;
import com.zhongz.rental.param.ZhongzUserServiceOrderParam;
import com.zhongz.rental.param.ZhongzUserServiceOrderWechatPayParam;
import com.zhongz.rental.result.ServiceOrderResult;
import com.zhongz.rental.result.base.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 服务订单 服务层
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
public interface IZhongzServiceOrderService 
{
	/**
     * 查询服务订单信息
     * 
     * @param id 服务订单ID
     * @return 服务订单信息
     */
	public ServiceOrderResult selectZhongzServiceOrderById(String id);
	
	/**
     * 查询服务订单列表
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 服务订单集合
     */
	public List<ZhongzServiceOrder> selectZhongzServiceOrderList(ZhongzServiceOrder zhongzServiceOrder);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairList(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus0(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已预约报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus1(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已完成报修订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus2(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningList(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已下单保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus0(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已预约保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus1(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）已完成保洁订单列表
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 服务订单集合
	 */
	public Result<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus2(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
     * 新增报修服务订单
     * 
     * @param zhongzUserServiceOrderParam 服务订单信息
     * @return 结果
     */
	public Result insertZhongzServiceOrder(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam, HttpServletRequest request);

	/**
	 * 新增保洁服务订单
	 *
	 * @param zhongzUserServiceOrderParam 服务订单信息
	 * @return 结果
	 */
	public Result insertZhongzServiceCleaningOrder(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam, HttpServletRequest request);

	/**
	 * 服务订单微信支付
	 *
	 * @param zhongzUserServiceOrderWechatPayParam 服务订单信息
	 * @return 结果
	 */
	public Result wechatPayZhongzServiceOrder(ZhongzUserServiceOrderWechatPayParam zhongzUserServiceOrderWechatPayParam);

	/**
     * 修改服务订单
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 结果
     */
	public int updateZhongzServiceOrder(ZhongzServiceOrder zhongzServiceOrder);

	/**
	 * 取消服务订单
	 *
	 * @param id 服务订单ID
	 * @return 结果
	 */
	public Result cancelZhongzServiceOrder(String id);

	/**
     * 删除服务订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzServiceOrderByIds(String ids);
	
}
