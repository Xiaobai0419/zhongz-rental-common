package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzHouse;
import com.zhongz.rental.param.ZhongzHouseParam;
import com.zhongz.rental.param.ZhongzHouseRentType;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.result.base.Result;

import java.util.List;

/**
 * 房屋 服务层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface IZhongzHouseService 
{
	/**
	 * 查询房屋信息
	 *
	 * @param id 房屋id
	 * @return 房屋信息
	 */
	public ZhongzHouse selectZhongzHouseById(String id);

	/**
     * 查询房屋信息
     * 
     * @param zhongzUserOrderParam 房屋用户信息
     * @return 房屋信息
     */
	public ZhongzHouse selectZhongzHouseById(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
	 * 查询单个房屋租期类别列表
	 *
	 * @param id 房屋ID
	 * @return 单个房屋租期类别列表
	 */
	public List<ZhongzHouseRentType> selectZhongzHouseRentTypesById(String id);

	/**
     * 查询房屋列表
     * 
     * @param zhongzHouse 房屋信息
     * @return 房屋集合
     */
	public List<ZhongzHouse> selectZhongzHouseList(ZhongzHouse zhongzHouse);

	/**
	 * 查询某用户有效租期内房屋列表（需要登录）
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 房屋集合
	 */
	public Result<ZhongzHouse> selectZhongzUserHouseList(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
	 * 客户端首页可租房源列表
	 *
	 * @param zhongzHouseParam 房屋信息
	 * @return 房屋集合
	 */
	public Result<ZhongzHouse> selectZhongzHouseRentList(ZhongzHouseParam zhongzHouseParam);

	/**
     * 新增房屋
     * 
     * @param zhongzHouse 房屋信息
     * @return 结果
     */
	public int insertZhongzHouse(ZhongzHouse zhongzHouse);
	
	/**
     * 修改房屋
     * 
     * @param zhongzHouse 房屋信息
     * @return 结果
     */
	public int updateZhongzHouse(ZhongzHouse zhongzHouse);
		
	/**
     * 删除房屋信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzHouseByIds(String ids);
	
}
