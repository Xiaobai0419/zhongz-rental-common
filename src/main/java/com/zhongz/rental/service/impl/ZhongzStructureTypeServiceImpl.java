package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzStructureType;
import com.zhongz.rental.mapper.ZhongzStructureTypeMapper;
import com.zhongz.rental.service.IZhongzStructureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 户型 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@Service
public class ZhongzStructureTypeServiceImpl implements IZhongzStructureTypeService
{
	@Autowired
	private ZhongzStructureTypeMapper zhongzStructureTypeMapper;

	/**
     * 查询户型信息
     * 
     * @param id 户型ID
     * @return 户型信息
     */
    @Override
	public ZhongzStructureType selectZhongzStructureTypeById(String id)
	{
	    return zhongzStructureTypeMapper.selectZhongzStructureTypeById(id);
	}
	
	/**
     * 查询户型列表
     * 
     * @param zhongzStructureType 户型信息
     * @return 户型集合
     */
	@Override
	public List<ZhongzStructureType> selectZhongzStructureTypeList(ZhongzStructureType zhongzStructureType)
	{
	    return zhongzStructureTypeMapper.selectZhongzStructureTypeList(zhongzStructureType);
	}

	/**
	 * 查询户型列表
	 *
	 * @return 户型集合
	 */
	@Override
	public List<ZhongzStructureType> selectZhongzStructureTypeList() {
		return zhongzStructureTypeMapper.selectZhongzStructureTypeAllList();
	}

    /**
     * 新增户型
     * 
     * @param zhongzStructureType 户型信息
     * @return 结果
     */
	@Override
	public int insertZhongzStructureType(ZhongzStructureType zhongzStructureType)
	{
	    return zhongzStructureTypeMapper.insertZhongzStructureType(zhongzStructureType);
	}
	
	/**
     * 修改户型
     * 
     * @param zhongzStructureType 户型信息
     * @return 结果
     */
	@Override
	public int updateZhongzStructureType(ZhongzStructureType zhongzStructureType)
	{
	    return zhongzStructureTypeMapper.updateZhongzStructureType(zhongzStructureType);
	}

	/**
     * 删除户型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzStructureTypeByIds(String ids)
	{
		return zhongzStructureTypeMapper.deleteZhongzStructureTypeByIds1(Convert.toStrArray(ids));
	}
	
}
