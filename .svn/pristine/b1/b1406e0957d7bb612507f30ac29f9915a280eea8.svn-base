package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzContract;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.result.base.Result;

import java.util.List;

/**
 * 合同 服务层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface IZhongzContractService 
{
	/**
     * 查询合同信息
     * 
     * @param id 合同ID
     * @return 合同信息
     */
	public ZhongzContract selectZhongzContractById(String id);
	
	/**
     * 查询合同列表
     * 
     * @param zhongzContract 合同信息
     * @return 合同集合
     */
	public List<ZhongzContract> selectZhongzContractList(ZhongzContract zhongzContract);

	/**
	 * 查询用户合同期内所有生效合同列表
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 订单集合
	 */
	public Result<ZhongzContract> selectZhongzUserContractList(ZhongzUserOrderParam zhongzUserOrderParam);

	/**
	 * 查询用户所有签约合同列表（包括已失效历史合同）
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 订单集合
	 */
	public Result<ZhongzContract> selectZhongzUserContractAllList(ZhongzUserOrderParam zhongzUserOrderParam);

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
     * 删除合同信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzContractByIds(String ids);
	
}
