package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 媒体文件表 zhongz_media_file
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@ApiModel(value="ZhongzMediaFile", description="")
public class ZhongzMediaFile extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 媒体文件类型 1 图片 2 视频 3 其他 */
	@ApiModelProperty(value="媒体文件类型 1 图片 2 视频 3 其他", dataType="Integer")
	private Integer mediaType;
	/** 所属业务 */
	@ApiModelProperty(value="所属业务", dataType="Integer")
	private Integer business;
	/** 文件所属实体id */
	@ApiModelProperty(value="文件所属实体id", dataType="String")
	private String entityId;
	/** 所属小类 */
	@ApiModelProperty(value="所属小类", dataType="Integer")
	private Integer category;
	/** 小类中排序 */
	@ApiModelProperty(value="小类中排序", dataType="Integer")
	private Integer categoryOrder;
	/** 文件描述 */
	@ApiModelProperty(value="文件描述", dataType="String")
	private String typeName;
	/** 存储地址 */
	@ApiModelProperty(value="存储地址", dataType="String")
	private String url;

	public Integer getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(Integer categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public void setMediaType(Integer mediaType)
	{
		this.mediaType = mediaType;
	}

	public Integer getMediaType() 
	{
		return mediaType;
	}
	public void setBusiness(Integer business) 
	{
		this.business = business;
	}

	public Integer getBusiness() 
	{
		return business;
	}
	public void setEntityId(String entityId) 
	{
		this.entityId = entityId;
	}

	public String getEntityId() 
	{
		return entityId;
	}
	public void setCategory(Integer category) 
	{
		this.category = category;
	}

	public Integer getCategory() 
	{
		return category;
	}

	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("mediaType", getMediaType())
				.append("business", getBusiness())
				.append("entityId", getEntityId())
				.append("category", getCategory())
				.append("categoryOrder", getCategoryOrder())
				.append("typeName", getTypeName())
				.append("url", getUrl())
				.append("createBy", getCreateBy())
				.append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime())
				.append("remark", getRemark())
				.append("status1", getStatus1())
				.toString();
	}
}
