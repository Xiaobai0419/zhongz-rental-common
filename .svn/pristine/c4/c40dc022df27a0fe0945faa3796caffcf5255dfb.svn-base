package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzManager;
import com.zhongz.rental.mapper.ZhongzManagerMapper;
import com.zhongz.rental.service.IZhongzManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 管家 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class ZhongzManagerServiceImpl implements IZhongzManagerService
{
	@Autowired
	private ZhongzManagerMapper zhongzManagerMapper;

	/**
     * 查询管家信息
     * 
     * @param id 管家ID
     * @return 管家信息
     */
    @Override
	public ZhongzManager selectZhongzManagerById(String id)
	{
	    return zhongzManagerMapper.selectZhongzManagerById(id);
	}

	/**
	 * 查询管家信息
	 *
	 * @return 管家信息
	 */
	@Override
	public ZhongzManager selectZhongzManager()
	{
		return zhongzManagerMapper.selectZhongzManager();
	}

	/**
     * 查询管家列表
     * 
     * @param zhongzManager 管家信息
     * @return 管家集合
     */
	@Override
	public List<ZhongzManager> selectZhongzManagerList(ZhongzManager zhongzManager)
	{
	    return zhongzManagerMapper.selectZhongzManagerList(zhongzManager);
	}
	
    /**
     * 新增管家
     * 
     * @param zhongzManager 管家信息
     * @return 结果
     */
	@Override
	public int insertZhongzManager(ZhongzManager zhongzManager)
	{
	    return zhongzManagerMapper.insertZhongzManager(zhongzManager);
	}
	
	/**
     * 修改管家
     * 
     * @param zhongzManager 管家信息
     * @return 结果
     */
	@Override
	public int updateZhongzManager(ZhongzManager zhongzManager)
	{
	    return zhongzManagerMapper.updateZhongzManager(zhongzManager);
	}

	/**
     * 删除管家对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzManagerByIds(String ids)
	{
		return zhongzManagerMapper.deleteZhongzManagerByIds1(Convert.toStrArray(ids));
	}
	
}
