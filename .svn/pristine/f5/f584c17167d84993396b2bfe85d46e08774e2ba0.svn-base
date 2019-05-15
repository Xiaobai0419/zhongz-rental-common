package com.zhongz.rental.mapper;

import com.zhongz.rental.domain.ZhongzMediaFile;

import java.util.List;

/**
 * 媒体文件 数据层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface ZhongzMediaFileMapper 
{
	/**
     * 查询媒体文件信息
     * 
     * @param id 媒体文件ID
     * @return 媒体文件信息
     */
	public ZhongzMediaFile selectZhongzMediaFileById(String id);

	/**
	 * 查询房源展示媒体文件信息
	 *
	 * @param zhongzMediaFile 媒体文件信息
	 * @return 媒体文件信息
	 */
	public List<ZhongzMediaFile> selectZhongzMediaFileByHouseEntity(ZhongzMediaFile zhongzMediaFile);

	/**
     * 查询媒体文件列表
     * 
     * @param zhongzMediaFile 媒体文件信息
     * @return 媒体文件集合
     */
	public List<ZhongzMediaFile> selectZhongzMediaFileList(ZhongzMediaFile zhongzMediaFile);
	
	/**
     * 新增媒体文件
     * 
     * @param zhongzMediaFile 媒体文件信息
     * @return 结果
     */
	public int insertZhongzMediaFile(ZhongzMediaFile zhongzMediaFile);
	
	/**
     * 修改媒体文件
     * 
     * @param zhongzMediaFile 媒体文件信息
     * @return 结果
     */
	public int updateZhongzMediaFile(ZhongzMediaFile zhongzMediaFile);

	/**
	 * 删除媒体文件（逻辑）
	 *
	 * @param id 媒体文件ID
	 * @return 结果
	 */
	public int deleteZhongzMediaFileById1(String id);

	/**
	 * 批量删除媒体文件（逻辑）
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteZhongzMediaFileByIds1(String[] ids);

	/**
     * 删除媒体文件
     * 
     * @param id 媒体文件ID
     * @return 结果
     */
	public int deleteZhongzMediaFileById(String id);
	
	/**
     * 批量删除媒体文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzMediaFileByIds(String[] ids);
	
}