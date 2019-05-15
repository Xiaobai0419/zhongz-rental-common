package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 合同 数据层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface ZhongzContractMapper 
{
	/**
     * 查询合同信息
     * 
     * @param id 合同ID
     * @return 合同信息
     */
	public ZhongzContract selectZhongzContractById(String id);

	/**
	 * 按用户和房子查询未签约状态有效首租订单
	 *
	 * @param tenantId 房客ID
	 * @param houseId 房屋ID
	 * @return 合同信息
	 */
	public Integer selectZhongzContractByUserAndHouse(@Param("tenantId") String tenantId, @Param("houseId") String houseId);

	/**
	 * 按用户和房子查询未签约状态有效续约订单
	 *
	 * @param tenantId 房客ID
	 * @param houseId 房屋ID
	 * @return 合同信息
	 */
	public Integer selectZhongzRenewContractByUserAndHouse(@Param("tenantId") String tenantId, @Param("houseId") String houseId);


	/**
	 * 按用户查询该用户所有生效期合同信息
	 *
	 * @param tenantId 房客ID
	 * @return 合同信息
	 */
	public List<ZhongzContract> selectZhongzContractByUser(@Param("tenantId") String tenantId, @Param("limitStart") Integer limitStart, @Param("limitNum") Integer limitNum);

	/**
	 * 查询用户选择房屋对应的最新租期内有效签约合同
	 *
	 * @param tenantId 房客ID
	 * @return 合同信息
	 */
	public ZhongzContract selectZhongzLatestContractByUserAndHouse(@Param("tenantId") String tenantId, @Param("houseId") String houseId);

	/**
	 * 按用户查询该用户所有合同信息（包括失效历史合同）
	 *
	 * @param tenantId 房客ID
	 * @return 合同信息
	 */
	public List<ZhongzContract> selectZhongzContractByTenantId(@Param("tenantId") String tenantId, @Param("limitStart") Integer limitStart, @Param("limitNum") Integer limitNum);

	/**
     * 查询合同列表
     * 
     * @param zhongzContract 合同信息
     * @return 合同集合
     */
	public List<ZhongzContract> selectZhongzContractList(ZhongzContract zhongzContract);

	/**
	 * 批量查询合同列表
	 *
	 * @param contractIds 合同id列表
	 * @return 合同集合
	 */
	public List<ZhongzContract> selectZhongzContractByIds(List<String> contractIds);

	/**
     * 新增合同
     * 
     * @param zhongzContract 合同信息
     * @return 结果
     */
	public int insertZhongzContract(ZhongzContract zhongzContract);
	
	/**
     * 修改合同
     * 
     * @param zhongzContract 合同信息
     * @return 结果
     */
	public int updateZhongzContract(ZhongzContract zhongzContract);

	/**
	 * 删除合同（批量）
	 *
	 * @param id 合同ID
	 * @return 结果
	 */
	public int deleteZhongzContractById1(String id);

	/**
	 * 批量删除合同（批量）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzContractByIds1(String[] ids);

	/**
     * 删除合同
     * 
     * @param id 合同ID
     * @return 结果
     */
	public int deleteZhongzContractById(String id);
	
	/**
     * 批量删除合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzContractByIds(String[] ids);


}