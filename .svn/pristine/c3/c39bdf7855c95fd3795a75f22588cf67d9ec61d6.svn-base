package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzDirectionType;
import com.zhongz.rental.mapper.ZhongzDirectionTypeMapper;
import com.zhongz.rental.service.IZhongzDirectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 朝向类型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@Service
public class ZhongzDirectionTypeServiceImpl implements IZhongzDirectionTypeService
{
	@Autowired
	private ZhongzDirectionTypeMapper zhongzDirectionTypeMapper;

	/**
     * 查询朝向类型信息
     * 
     * @param id 朝向类型ID
     * @return 朝向类型信息
     */
    @Override
	public ZhongzDirectionType selectZhongzDirectionTypeById(String id)
	{
	    return zhongzDirectionTypeMapper.selectZhongzDirectionTypeById(id);
	}
	
	/**
     * 查询朝向类型列表
     * 
     * @param zhongzDirectionType 朝向类型信息
     * @return 朝向类型集合
     */
	@Override
	public List<ZhongzDirectionType> selectZhongzDirectionTypeList(ZhongzDirectionType zhongzDirectionType)
	{
	    return zhongzDirectionTypeMapper.selectZhongzDirectionTypeList(zhongzDirectionType);
	}
	
    /**
     * 新增朝向类型
     * 
     * @param zhongzDirectionType 朝向类型信息
     * @return 结果
     */
	@Override
	public int insertZhongzDirectionType(ZhongzDirectionType zhongzDirectionType)
	{
	    return zhongzDirectionTypeMapper.insertZhongzDirectionType(zhongzDirectionType);
	}
	
	/**
     * 修改朝向类型
     * 
     * @param zhongzDirectionType 朝向类型信息
     * @return 结果
     */
	@Override
	public int updateZhongzDirectionType(ZhongzDirectionType zhongzDirectionType)
	{
	    return zhongzDirectionTypeMapper.updateZhongzDirectionType(zhongzDirectionType);
	}

	/**
     * 删除朝向类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzDirectionTypeByIds(String ids)
	{
		return zhongzDirectionTypeMapper.deleteZhongzDirectionTypeByIds1(Convert.toStrArray(ids));
	}
	
}
