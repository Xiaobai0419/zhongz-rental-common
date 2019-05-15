package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 小区表 zhongz_estate
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@ApiModel(value="ZhongzEstate", description="")
public class ZhongzEstate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 小区名称 */
	@ApiModelProperty(value="小区名称", dataType="String")
	private String name;
	/** 小区简称 */
	@ApiModelProperty(value="小区简称", dataType="String")
	private String shortName;
	/** 小区商圈 */
	@ApiModelProperty(value="小区商圈", dataType="String")
	private String commerce;
	/** 建筑年代 */
	@ApiModelProperty(value="建筑年代", dataType="Integer")
	private Integer age;
	/** 建筑类型 */
	@ApiModelProperty(value="建筑类型", dataType="Integer")
	private Integer buildingType;
	/** 建筑类型名 */
	@ApiModelProperty(value="建筑类型名", dataType="String")
	private String buildingTypeName;
	/** 小区位置 */
	@ApiModelProperty(value="小区位置", dataType="String")
	private String address;
	/** 经度 */
	@ApiModelProperty(value="经度", dataType="Double")
	private Double longitude;
	/** 纬度 */
	@ApiModelProperty(value="纬度", dataType="Double")
	private Double latitude;
	/** 小区照片 */
	@ApiModelProperty(value="小区照片", dataType="String")
	private String picture;
	/** 小区简介 */
	@ApiModelProperty(value="小区简介", dataType="String")
	private String description;

	public String getBuildingTypeName() {
		return buildingTypeName;
	}

	public void setBuildingTypeName(String buildingTypeName) {
		this.buildingTypeName = buildingTypeName;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setShortName(String shortName) 
	{
		this.shortName = shortName;
	}

	public String getShortName() 
	{
		return shortName;
	}
	public void setCommerce(String commerce) 
	{
		this.commerce = commerce;
	}

	public String getCommerce() 
	{
		return commerce;
	}
	public void setAge(Integer age) 
	{
		this.age = age;
	}

	public Integer getAge() 
	{
		return age;
	}
	public void setBuildingType(Integer buildingType) 
	{
		this.buildingType = buildingType;
	}

	public Integer getBuildingType() 
	{
		return buildingType;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
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
            .append("shortName", getShortName())
            .append("commerce", getCommerce())
            .append("age", getAge())
            .append("buildingType", getBuildingType())
            .append("address", getAddress())
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
