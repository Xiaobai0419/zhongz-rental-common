package com.zhongz.rental.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 房屋表 zhongz_house
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@ApiModel(value="ZhongzHouse", description="")
public class ZhongzHouse extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 房子租住状态 */
	@ApiModelProperty(value="房子租住状态 0 未租 1 已租", dataType="Integer")
	private Integer rentStatus;
	/** 租住方式（整租、合租） */
	@ApiModelProperty(value="租住方式（1 整租 2 合租）", dataType="Integer")
	private Integer rentType;
	/** 房屋位置 */
	@ApiModelProperty(value="房屋位置", dataType="String")
	private String address;
	/** 经度 */
	@ApiModelProperty(value="经度", dataType="Double")
	private Double longitude;
	/** 纬度 */
	@ApiModelProperty(value="纬度", dataType="Double")
	private Double latitude;
	/** 房屋标题描述 */
	@ApiModelProperty(value="房屋标题描述", dataType="String")
	private String title;
	/** 房屋描述 */
	@ApiModelProperty(value="房屋描述", dataType="String")
	private String description;
	/** 小区id */
	@ApiModelProperty(value="小区id", dataType="String")
	private String estateId;
	/** 小区名 */
	@ApiModelProperty(value="小区名", dataType="String")
	private String estateName;
	/** 区域 */
	@ApiModelProperty(value="区域", dataType="String")
	private String region;
	/** 幢 */
	@ApiModelProperty(value="幢", dataType="Integer")
	private Integer building;
	/** 单元 */
	@ApiModelProperty(value="单元", dataType="Integer")
	private Integer unit;
	/** 室 */
	@ApiModelProperty(value="室", dataType="String")
	private String roomNumber;
	/** 楼层 */
	@ApiModelProperty(value="楼层", dataType="Integer")
	private Integer floor;
	/** 总楼层 */
	@ApiModelProperty(value="总楼层", dataType="Integer")
	private Integer floors;
	/** 户型 */
	@ApiModelProperty(value="户型", dataType="Integer")
	private Integer structure;
	/** 户型名 */
	@ApiModelProperty(value="户型名", dataType="String")
	private String structureName;
	/** 面积 */
	@ApiModelProperty(value="面积", dataType="Double")
	private Double area;
	/** 朝向 */
	@ApiModelProperty(value="朝向", dataType="Integer")
	private Integer direction;
	/** 朝向名 */
	@ApiModelProperty(value="朝向名", dataType="String")
	private String directionName;
	/** 月租金 */
	@ApiModelProperty(value="月租金", dataType="Double")
	private Double monthlyRent;
	/** 房屋软装配置 */
	@ApiModelProperty(value="房屋软装配置，分号分割，空为无", dataType="String")
	private String softConfigs;
	/** 房屋电器配置 */
	@ApiModelProperty(value="房屋电器配置，分号分割，空为无", dataType="String")
	private String electricConfigs;
	/** 热度标签 */
	@ApiModelProperty(value="热度标签，分号分割", dataType="String")
	private String tags;
	/** 前端展示 */
	@ApiModelProperty(value="前端展示 0 不展示 1 展示", dataType="Integer")
	private Integer frontend;
	/** 总热度值 */
	private Integer tagsValue;
	/** 第一张图 */
	@ApiModelProperty(value="第一张图", dataType="String")
	private String firstPicture;

	@ApiModelProperty(value="所在小区，具体见小区字段", dataType="ZhongzEstate")
	private ZhongzEstate estate;

	@ApiModelProperty(value="合租房所有房间（出租、未出租）")
	private List<ZhongzRoom> rooms;

	@ApiModelProperty(value="用户预约状态 0 未预约 1 已预约")
	private Integer userHasOrder = 0;

	public Integer getUserHasOrder() {
		return userHasOrder;
	}

	public void setUserHasOrder(Integer userHasOrder) {
		this.userHasOrder = userHasOrder;
	}

	public List<ZhongzRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<ZhongzRoom> rooms) {
		this.rooms = rooms;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getFirstPicture() {
		return firstPicture;
	}

	public void setFirstPicture(String firstPicture) {
		this.firstPicture = firstPicture;
	}

	public ZhongzEstate getEstate() {
		return estate;
	}

	public void setEstate(ZhongzEstate estate) {
		this.estate = estate;
	}

	public Integer getTagsValue() {
		return tagsValue;
	}

	public void setTagsValue(Integer tagsValue) {
		this.tagsValue = tagsValue;
	}

	public void setRentStatus(Integer rentStatus)
	{
		this.rentStatus = rentStatus;
	}

	public Integer getRentStatus() 
	{
		return rentStatus;
	}
	public void setRentType(Integer rentType) 
	{
		this.rentType = rentType;
	}

	public Integer getRentType() 
	{
		return rentType;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setLongitude(Double longitude) 
	{
		this.longitude = longitude;
	}

	public Double getLongitude() 
	{
		return longitude;
	}
	public void setLatitude(Double latitude) 
	{
		this.latitude = latitude;
	}

	public Double getLatitude() 
	{
		return latitude;
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
	public void setEstateId(String estateId) 
	{
		this.estateId = estateId;
	}

	public String getEstateId() 
	{
		return estateId;
	}
	public void setRegion(String region) 
	{
		this.region = region;
	}

	public String getRegion() 
	{
		return region;
	}
	public void setBuilding(Integer building) 
	{
		this.building = building;
	}

	public Integer getBuilding() 
	{
		return building;
	}
	public void setUnit(Integer unit) 
	{
		this.unit = unit;
	}

	public Integer getUnit() 
	{
		return unit;
	}
	public void setRoomNumber(String roomNumber) 
	{
		this.roomNumber = roomNumber;
	}

	public String getRoomNumber() 
	{
		return roomNumber;
	}
	public void setFloor(Integer floor) 
	{
		this.floor = floor;
	}

	public Integer getFloor() 
	{
		return floor;
	}
	public void setFloors(Integer floors) 
	{
		this.floors = floors;
	}

	public Integer getFloors() 
	{
		return floors;
	}
	public void setStructure(Integer structure) 
	{
		this.structure = structure;
	}

	public Integer getStructure() 
	{
		return structure;
	}
	public void setArea(Double area) 
	{
		this.area = area;
	}

	public Double getArea() 
	{
		return area;
	}
	public void setDirection(Integer direction) 
	{
		this.direction = direction;
	}

	public Integer getDirection() 
	{
		return direction;
	}
	public void setMonthlyRent(Double monthlyRent) 
	{
		this.monthlyRent = monthlyRent;
	}

	public Double getMonthlyRent() 
	{
		return monthlyRent;
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
	public void setTags(String tags)
	{
		this.tags = tags;
	}

	public String getTags()
	{
		return tags;
	}
	public void setFrontend(Integer frontend) 
	{
		this.frontend = frontend;
	}

	public Integer getFrontend() 
	{
		return frontend;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("rentStatus", getRentStatus())
				.append("rentType", getRentType())
				.append("address", getAddress())
				.append("longitude", getLongitude())
				.append("latitude", getLatitude())
				.append("title", getTitle())
				.append("description", getDescription())
				.append("estateId", getEstateId())
				.append("region", getRegion())
				.append("building", getBuilding())
				.append("unit", getUnit())
				.append("roomNumber", getRoomNumber())
				.append("floor", getFloor())
				.append("floors", getFloors())
				.append("structure", getStructure())
				.append("area", getArea())
				.append("direction", getDirection())
				.append("monthlyRent", getMonthlyRent())
				.append("createBy", getCreateBy())
				.append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime())
				.append("remark", getRemark())
				.append("status1", getStatus1())
				.append("softConfigs", getSoftConfigs())
				.append("electricConfigs", getElectricConfigs())
				.append("tags", getTags())
				.append("frontend", getFrontend())
				.toString();
	}
}
