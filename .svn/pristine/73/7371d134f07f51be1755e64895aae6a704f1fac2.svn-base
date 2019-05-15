package com.zhongz.rental.service;

import com.zhongz.rental.domain.ZhongzMediaFile;

import java.util.List;

/**
 * 媒体文件 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IZhongzMediaFileService 
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
     * 删除媒体文件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZhongzMediaFileByIds(String ids);
	
}
