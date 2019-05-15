package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzRentType;
import com.zhongz.rental.mapper.ZhongzRentTypeMapper;
import com.zhongz.rental.service.IZhongzRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 租赁时长类别 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@Service
public class ZhongzRentTypeServiceImpl implements IZhongzRentTypeService
{
	@Autowired
	private ZhongzRentTypeMapper zhongzRentTypeMapper;

	/**
     * 查询租赁时长类别信息
     * 
     * @param id 租赁时长类别ID
     * @return 租赁时长类别信息
     */
    @Override
	public ZhongzRentType selectZhongzRentTypeById(String id)
	{
	    return zhongzRentTypeMapper.selectZhongzRentTypeById(id);
	}
	
	/**
     * 查询租赁时长类别列表
     * 
     * @param zhongzRentType 租赁时长类别信息
     * @return 租赁时长类别集合
     */
	@Override
	public List<ZhongzRentType> selectZhongzRentTypeList(ZhongzRentType zhongzRentType)
	{
	    return zhongzRentTypeMapper.selectZhongzRentTypeList(zhongzRentType);
	}
	
    /**
     * 新增租赁时长类别
     * 
     * @param zhongzRentType 租赁时长类别信息
     * @return 结果
     */
	@Override
	public int insertZhongzRentType(ZhongzRentType zhongzRentType)
	{
	    return zhongzRentTypeMapper.insertZhongzRentType(zhongzRentType);
	}
	
	/**
     * 修改租赁时长类别
     * 
     * @param zhongzRentType 租赁时长类别信息
     * @return 结果
     */
	@Override
	public int updateZhongzRentType(ZhongzRentType zhongzRentType)
	{
	    return zhongzRentTypeMapper.updateZhongzRentType(zhongzRentType);
	}

	/**
     * 删除租赁时长类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzRentTypeByIds(String ids)
	{
		return zhongzRentTypeMapper.deleteZhongzRentTypeByIds1(Convert.toStrArray(ids));
	}
	
}
