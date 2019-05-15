package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzServiceOrder;
import com.zhongz.rental.param.ZhongzUserServiceOrderParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 服务订单 数据层
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
public interface ZhongzServiceOrderMapper 
{
	/**
     * 查询服务订单信息
     * 
     * @param id 服务订单ID
     * @return 服务订单信息
     */
	public ZhongzServiceOrder selectZhongzServiceOrderById(String id);
	
	/**
     * 查询服务订单列表
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 服务订单集合
     */
	public List<ZhongzServiceOrder> selectZhongzServiceOrderList(ZhongzServiceOrder zhongzServiceOrder);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）报修订单列表
	 * @param zhongzUserServiceOrderParam
	 * @return
	 */
	public List<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairList(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 按订单状态查询（分页，几条按传入pageSize参数限制）报修订单列表
	 * @param zhongzUserServiceOrderParam
	 * @return
	 */
	public List<ZhongzServiceOrder> selectZhongzServiceOrderUserRepairListByStatus(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询（分页，几条按传入pageSize参数限制）保洁订单列表
	 * @param zhongzUserServiceOrderParam
	 * @return
	 */
	public List<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningList(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 按订单状态查询（分页，几条按传入pageSize参数限制）保洁订单列表
	 * @param zhongzUserServiceOrderParam
	 * @return
	 */
	public List<ZhongzServiceOrder> selectZhongzServiceOrderUserCleaningListByStatus(ZhongzUserServiceOrderParam zhongzUserServiceOrderParam);

	/**
	 * 查询报修/保洁订单日最大序号
	 *
	 * @return 订单信息
	 */
	public Integer selectZhongzServiceOrderDayMaxOrder(@Param("orderType") Integer orderType);

	/**
	 * 查询该用户该房屋同一类型未受理完成服务订单
	 *
	 * @return 订单信息
	 */
	public Integer selectZhongzServiceOrderByUserHouseAndType(@Param("tenantId") String tenantId,@Param("houseId") String houseId,@Param("orderType") Integer orderType);

	/**
     * 新增服务订单
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 结果
     */
	public int insertZhongzServiceOrder(ZhongzServiceOrder zhongzServiceOrder);
	
	/**
     * 修改服务订单
     * 
     * @param zhongzServiceOrder 服务订单信息
     * @return 结果
     */
	public int updateZhongzServiceOrder(ZhongzServiceOrder zhongzServiceOrder);

	/**
	 * 取消订单
	 * @param id
	 * @return
	 */
	public int cancelZhongzServiceOrder(String id);

	/**
	 * 删除服务订单（逻辑）
	 *
	 * @param id 服务订单ID
	 * @return 结果
	 */
	public int deleteZhongzServiceOrderById1(String id);

	/**
	 * 批量删除服务订单（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzServiceOrderByIds1(String[] ids);

	/**
     * 删除服务订单
     * 
     * @param id 服务订单ID
     * @return 结果
     */
	public int deleteZhongzServiceOrderById(String id);
	
	/**
     * 批量删除服务订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzServiceOrderByIds(String[] ids);
}