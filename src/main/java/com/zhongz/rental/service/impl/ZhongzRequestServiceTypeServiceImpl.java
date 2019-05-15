package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzRequestServiceType;
import com.zhongz.rental.mapper.ZhongzRequestServiceTypeMapper;
import com.zhongz.rental.service.IZhongzRequestServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 请求服务类型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
@Service
public class ZhongzRequestServiceTypeServiceImpl implements IZhongzRequestServiceTypeService
{
	@Autowired
	private ZhongzRequestServiceTypeMapper zhongzRequestServiceTypeMapper;

	/**
     * 查询请求服务类型信息
     * 
     * @param id 请求服务类型ID
     * @return 请求服务类型信息
     */
    @Override
	public ZhongzRequestServiceType selectZhongzRequestServiceTypeById(String id)
	{
	    return zhongzRequestServiceTypeMapper.selectZhongzRequestServiceTypeById(id);
	}
	
	/**
     * 查询请求服务类型列表
     * 
     * @param zhongzRequestServiceType 请求服务类型信息
     * @return 请求服务类型集合
     */
	@Override
	public List<ZhongzRequestServiceType> selectZhongzRequestServiceTypeList(ZhongzRequestServiceType zhongzRequestServiceType)
	{
	    return zhongzRequestServiceTypeMapper.selectZhongzRequestServiceTypeList(zhongzRequestServiceType);
	}

	/**
	 * 查询报修类型列表
	 *
	 * @return 请求服务类型集合
	 */
	@Override
	public List<ZhongzRequestServiceType> selectZhongzRequestServiceRepair()
	{
		return zhongzRequestServiceTypeMapper.selectZhongzRequestServiceRepair();
	}

	/**
	 * 查询保洁类型列表
	 *
	 * @return 请求服务类型集合
	 */
	@Override
	public List<ZhongzRequestServiceType> selectZhongzRequestServiceCleaning()
	{
		return zhongzRequestServiceTypeMapper.selectZhongzRequestServiceCleaning();
	}

    /**
     * 新增请求服务类型
     * 
     * @param zhongzRequestServiceType 请求服务类型信息
     * @return 结果
     */
	@Override
	public int insertZhongzRequestServiceType(ZhongzRequestServiceType zhongzRequestServiceType)
	{
	    return zhongzRequestServiceTypeMapper.insertZhongzRequestServiceType(zhongzRequestServiceType);
	}
	
	/**
     * 修改请求服务类型
     * 
     * @param zhongzRequestServiceType 请求服务类型信息
     * @return 结果
     */
	@Override
	public int updateZhongzRequestServiceType(ZhongzRequestServiceType zhongzRequestServiceType)
	{
	    return zhongzRequestServiceTypeMapper.updateZhongzRequestServiceType(zhongzRequestServiceType);
	}

	/**
     * 删除请求服务类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzRequestServiceTypeByIds(String ids)
	{
		return zhongzRequestServiceTypeMapper.deleteZhongzRequestServiceTypeByIds1(Convert.toStrArray(ids));
	}
	
}
