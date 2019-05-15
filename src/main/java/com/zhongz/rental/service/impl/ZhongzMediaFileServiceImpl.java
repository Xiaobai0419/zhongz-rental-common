package com.zhongz.rental.service.impl;

import java.util.List;

import com.zhongz.rental.domain.ZhongzMediaFile;
import com.zhongz.rental.mapper.ZhongzMediaFileMapper;
import com.zhongz.rental.service.IZhongzMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 媒体文件 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class ZhongzMediaFileServiceImpl implements IZhongzMediaFileService
{
	@Autowired
	private ZhongzMediaFileMapper zhongzMediaFileMapper;

	/**
     * 查询媒体文件信息
     * 
     * @param id 媒体文件ID
     * @return 媒体文件信息
     */
    @Override
	public ZhongzMediaFile selectZhongzMediaFileById(String id)
	{
	    return zhongzMediaFileMapper.selectZhongzMediaFileById(id);
	}

	/**
	 * 查询房源展示媒体文件信息
	 *
	 * @param zhongzMediaFile 媒体文件信息
	 * @return 媒体文件信息
	 */
	@Override
	public List<ZhongzMediaFile> selectZhongzMediaFileByHouseEntity(ZhongzMediaFile zhongzMediaFile)
	{
		return zhongzMediaFileMapper.selectZhongzMediaFileByHouseEntity(zhongzMediaFile);
	}

	/**
     * 查询媒体文件列表
     * 
     * @param zhongzMediaFile 媒体文件信息
     * @return 媒体文件集合
     */
	@Override
	public List<ZhongzMediaFile> selectZhongzMediaFileList(ZhongzMediaFile zhongzMediaFile)
	{
	    return zhongzMediaFileMapper.selectZhongzMediaFileList(zhongzMediaFile);
	}
	
    /**
     * 新增媒体文件
     * 
     * @param zhongzMediaFile 媒体文件信息
     * @return 结果
     */
	@Override
	public int insertZhongzMediaFile(ZhongzMediaFile zhongzMediaFile)
	{
	    return zhongzMediaFileMapper.insertZhongzMediaFile(zhongzMediaFile);
	}
	
	/**
     * 修改媒体文件
     * 
     * @param zhongzMediaFile 媒体文件信息
     * @return 结果
     */
	@Override
	public int updateZhongzMediaFile(ZhongzMediaFile zhongzMediaFile)
	{
	    return zhongzMediaFileMapper.updateZhongzMediaFile(zhongzMediaFile);
	}

	/**
     * 删除媒体文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzMediaFileByIds(String ids)
	{
		return zhongzMediaFileMapper.deleteZhongzMediaFileByIds1(Convert.toStrArray(ids));
	}
	
}
