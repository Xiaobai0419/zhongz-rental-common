package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 房间表 zhongz_room
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@ApiModel(value="ZhongzRoom", description="")
public class ZhongzRoom extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 所属房屋id */
	@ApiModelProperty(value="所属房屋id", dataType="String")
	private String houseId;
	/** 房间租住状态 */
	@ApiModelProperty(value="房间租住状态 0 未租 1 已租", dataType="Integer")
	private Integer rentStatus;
	/** 朝向 */
	@ApiModelProperty(value="朝向", dataType="Integer")
	private Integer direction;
	/** 朝向名 */
	@ApiModelProperty(value="朝向名", dataType="String")
	private String directionName;
	/** 月租金 */
	@ApiModelProperty(value="月租金", dataType="Double")
	private Double monthlyRent;
	/** 面积 */
	@ApiModelProperty(value="面积", dataType="Double")
	private Double area;
	/** 房间标题描述 */
	@ApiModelProperty(value="房间标题描述", dataType="String")
	private String title;
	/** 房间描述 */
	@ApiModelProperty(value="房间描述", dataType="String")
	private String description;
	/** 房间软装配置 */
	@ApiModelProperty(value="房间软装配置", dataType="String")
	private String softConfigs;
	/** 房间电器配置 */
	@ApiModelProperty(value="房间电器配置", dataType="String")
	private String electricConfigs;

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public void setHouseId(String houseId)
	{
		this.houseId = houseId;
	}

	public String getHouseId() 
	{
		return houseId;
	}
	public void setRentStatus(Integer rentStatus) 
	{
		this.rentStatus = rentStatus;
	}

	public Integer getRentStatus() 
	{
		return rentStatus;
	}
	public void setMonthlyRent(Double monthlyRent) 
	{
		this.monthlyRent = monthlyRent;
	}

	public Double getMonthlyRent() 
	{
		return monthlyRent;
	}
	public void setArea(Double area) 
	{
		this.area = area;
	}

	public Double getArea() 
	{
		return area;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setSoftConfigs(String softConfigs) 
	{
		this.softConfigs = softConfigs;
	}

	public String getSoftConfigs() 
	{
		return softConfigs;
	}
	public void setElectricConfigs(String electricConfigs) 
	{
		this.electricConfigs = electricConfigs;
	}

	public String getElectricConfigs() 
	{
		return electricConfigs;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("houseId", getHouseId())
            .append("rentStatus", getRentStatus())
            .append("monthlyRent", getMonthlyRent())
            .append("area", getArea())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("softConfigs", getSoftConfigs())
            .append("electricConfigs", getElectricConfigs())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
