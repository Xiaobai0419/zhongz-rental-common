package com.zhongz.rental.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.zhongz.rental.domain.ZhongzServiceType;
import com.zhongz.rental.mapper.ZhongzServiceTypeMapper;
import com.zhongz.rental.service.IZhongzServiceTypeService;

/**
 * 服务类型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-30
 */
@Service
public class ZhongzServiceTypeServiceImpl implements IZhongzServiceTypeService 
{
	@Autowired
	private ZhongzServiceTypeMapper zhongzServiceTypeMapper;

	/**
     * 查询服务类型信息
     * 
     * @param id 服务类型ID
     * @return 服务类型信息
     */
    @Override
	public ZhongzServiceType selectZhongzServiceTypeById(String id)
	{
	    return zhongzServiceTypeMapper.selectZhongzServiceTypeById(id);
	}
	
	/**
     * 查询服务类型列表
     * 
     * @param zhongzServiceType 服务类型信息
     * @return 服务类型集合
     */
	@Override
	public List<ZhongzServiceType> selectZhongzServiceTypeList(ZhongzServiceType zhongzServiceType)
	{
	    return zhongzServiceTypeMapper.selectZhongzServiceTypeList(zhongzServiceType);
	}
	
    /**
     * 新增服务类型
     * 
     * @param zhongzServiceType 服务类型信息
     * @return 结果
     */
	@Override
	public int insertZhongzServiceType(ZhongzServiceType zhongzServiceType)
	{
	    return zhongzServiceTypeMapper.insertZhongzServiceType(zhongzServiceType);
	}
	
	/**
     * 修改服务类型
     * 
     * @param zhongzServiceType 服务类型信息
     * @return 结果
     */
	@Override
	public int updateZhongzServiceType(ZhongzServiceType zhongzServiceType)
	{
	    return zhongzServiceTypeMapper.updateZhongzServiceType(zhongzServiceType);
	}

	/**
     * 删除服务类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzServiceTypeByIds(String ids)
	{
		return zhongzServiceTypeMapper.deleteZhongzServiceTypeByIds(Convert.toStrArray(ids));
	}

	@Override
	public int updateZhongzServiceTypeByIds(Map<String, Object> params, String ids) {
		params.put("ids", Convert.toStrArray(ids));
		return zhongzServiceTypeMapper.updateZhongzServiceTypeByIds(params);
	}
	
}
