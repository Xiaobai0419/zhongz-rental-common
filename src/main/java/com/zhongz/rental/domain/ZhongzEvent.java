package com.zhongz.rental.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 活动表 zhongz_event
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@ApiModel(value="ZhongzEvent", description="")
public class ZhongzEvent extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 活动名称 */
    @ApiModelProperty(value="活动名称", dataType="String")
	private String name;
	/** 活动截止时间 */
    @ApiModelProperty(value="活动截止时间", dataType="Date")
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8"
	)
	private Date endTime;
	/** 前端展示 */
    @ApiModelProperty(value="前端展示", dataType="Integer")
	private Integer frontend;
	/** 前端展示排序 */
    @ApiModelProperty(value="前端展示排序", dataType="Integer")
	private Integer frontendOrder;
	/** 是否关联房屋 */
    @ApiModelProperty(value="是否关联房屋", dataType="Integer")
	private Integer houseRelated;
	/** 通栏广告图 */
    @ApiModelProperty(value="通栏广告图", dataType="String")
	private String picture;
	/** 活动内容 */
    @ApiModelProperty(value="活动内容", dataType="String")
	private String description;

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setFrontend(Integer frontend) 
	{
		this.frontend = frontend;
	}

	public Integer getFrontend() 
	{
		return frontend;
	}
	public void setFrontendOrder(Integer frontendOrder) 
	{
		this.frontendOrder = frontendOrder;
	}

	public Integer getFrontendOrder() 
	{
		return frontendOrder;
	}
	public void setHouseRelated(Integer houseRelated) 
	{
		this.houseRelated = houseRelated;
	}

	public Integer getHouseRelated() 
	{
		return houseRelated;
	}
	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	public String getPicture() 
	{
		return picture;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("endTime", getEndTime())
            .append("frontend", getFrontend())
            .append("frontendOrder", getFrontendOrder())
            .append("houseRelated", getHouseRelated())
            .append("picture", getPicture())
            .append("description", getDescription())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
