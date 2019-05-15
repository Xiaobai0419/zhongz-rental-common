package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzEstate;
import com.zhongz.rental.mapper.ZhongzEstateMapper;
import com.zhongz.rental.service.IZhongzEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 小区 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@Service
public class ZhongzEstateServiceImpl implements IZhongzEstateService
{
	@Autowired
	private ZhongzEstateMapper zhongzEstateMapper;

	/**
     * 查询小区信息
     * 
     * @param id 小区ID
     * @return 小区信息
     */
    @Override
	public ZhongzEstate selectZhongzEstateById(String id)
	{
	    return zhongzEstateMapper.selectZhongzEstateById(id);
	}
	
	/**
     * 查询小区列表
     * 
     * @param zhongzEstate 小区信息
     * @return 小区集合
     */
	@Override
	public List<ZhongzEstate> selectZhongzEstateList(ZhongzEstate zhongzEstate)
	{
	    return zhongzEstateMapper.selectZhongzEstateList(zhongzEstate);
	}

	/**
	 * 查询小区列表
	 *
	 * @return 小区集合
	 */
	@Override
	public List<ZhongzEstate> selectZhongzEstateList() {
		return zhongzEstateMapper.selectZhongzEstateAllList();
	}

    /**
     * 新增小区
     * 
     * @param zhongzEstate 小区信息
     * @return 结果
     */
	@Override
	public int insertZhongzEstate(ZhongzEstate zhongzEstate)
	{
	    return zhongzEstateMapper.insertZhongzEstate(zhongzEstate);
	}
	
	/**
     * 修改小区
     * 
     * @param zhongzEstate 小区信息
     * @return 结果
     */
	@Override
	public int updateZhongzEstate(ZhongzEstate zhongzEstate)
	{
	    return zhongzEstateMapper.updateZhongzEstate(zhongzEstate);
	}

	/**
     * 删除小区对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzEstateByIds(String ids)
	{
		return zhongzEstateMapper.deleteZhongzEstateByIds1(Convert.toStrArray(ids));
	}
	
}
