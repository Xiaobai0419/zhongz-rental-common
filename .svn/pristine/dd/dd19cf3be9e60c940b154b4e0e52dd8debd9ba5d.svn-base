package com.zhongz.rental.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.zhongz.rental.domain.ZhongzEntrust;
import com.zhongz.rental.mapper.ZhongzEntrustMapper;
import com.zhongz.rental.service.IZhongzEntrustService;

/**
 * 业主委托 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-28
 */
@Service
public class ZhongzEntrustServiceImpl implements IZhongzEntrustService 
{
	@Autowired
	private ZhongzEntrustMapper zhongzEntrustMapper;

	/**
     * 查询业主委托信息
     * 
     * @param id 业主委托ID
     * @return 业主委托信息
     */
    @Override
	public ZhongzEntrust selectZhongzEntrustById(String id)
	{
	    return zhongzEntrustMapper.selectZhongzEntrustById(id);
	}
	
	/**
     * 查询业主委托列表
     * 
     * @param zhongzEntrust 业主委托信息
     * @return 业主委托集合
     */
	@Override
	public List<ZhongzEntrust> selectZhongzEntrustList(ZhongzEntrust zhongzEntrust)
	{
	    return zhongzEntrustMapper.selectZhongzEntrustList(zhongzEntrust);
	}
	
    /**
     * 新增业主委托
     * 
     * @param zhongzEntrust 业主委托信息
     * @return 结果
     */
	@Override
	public int insertZhongzEntrust(ZhongzEntrust zhongzEntrust)
	{
	    return zhongzEntrustMapper.insertZhongzEntrust(zhongzEntrust);
	}
	
	/**
     * 修改业主委托
     * 
     * @param zhongzEntrust 业主委托信息
     * @return 结果
     */
	@Override
	public int updateZhongzEntrust(ZhongzEntrust zhongzEntrust)
	{
	    return zhongzEntrustMapper.updateZhongzEntrust(zhongzEntrust);
	}

	/**
     * 删除业主委托对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzEntrustByIds(String ids)
	{
		return zhongzEntrustMapper.deleteZhongzEntrustByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ZhongzEntrust> selectZhongzEntrustJoinUserList(ZhongzEntrust zhongzEntrust) {
		return zhongzEntrustMapper.selectZhongzEntrustJoinUserList(zhongzEntrust);
	}

	@Override
	public int updateZhongzEntrustByIds(Map<String, Object> params, String ids) {
		params.put("ids", Convert.toStrArray(ids));
		return zhongzEntrustMapper.updateZhongzEntrustByIds(params);
	}
	
}
