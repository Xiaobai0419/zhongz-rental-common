package com.zhongz.rental.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 服务订单表 zhongz_service_order
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
@ApiModel(value="ZhongzServiceOrder", description="")
public class ZhongzServiceOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单类型 */
	@ApiModelProperty(value="订单类型", dataType="Integer")
	private Integer orderType = 0;
	/** 订单号 */
	@ApiModelProperty(value="订单号", dataType="String")
	private String orderId;
	/** 当日订单排序 */
	@ApiModelProperty(value="当日订单排序", dataType="Integer")
	private Integer orderDayOrder = 0;
	/** 订单状态 */
	@ApiModelProperty(value="订单状态", dataType="Integer")
	private Integer orderStatus;
	/** 预约时间 */
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8"
	)
	@ApiModelProperty(value="预约时间", dataType="Date")
	private Date orderTime;
	/** 租住房屋id */
	@ApiModelProperty(value="租住房屋id", dataType="String")
	private String houseId;
	/** 承租人id */
	@ApiModelProperty(value="承租人id", dataType="String")
	private String tenantId;
	/** 受理人id */
	@ApiModelProperty(value="受理人id", dataType="String")
	private String renterId;
	/** 受理时间 */
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8"
	)
	@ApiModelProperty(value="受理时间", dataType="Date")
	private Date acceptTime;
	/** 请求服务类型 */
	@ApiModelProperty(value="请求服务类型", dataType="Integer")
	private Integer requestServiceType;
	/** 服务描述内容 */
	@ApiModelProperty(value="服务描述内容", dataType="String")
	private String serviceDescription;
	/** 现场图片 */
	@ApiModelProperty(value="现场图片", dataType="String")
	private String pictures;
	/** 指派人员 */
	@ApiModelProperty(value="指派人员", dataType="String")
	private String serverId;
	/** 指派人员联系电话 */
	@ApiModelProperty(value="指派人员联系电话", dataType="String")
	private String serverMobile;
	/** 服务实付金额 */
	@ApiModelProperty(value="服务实付金额", dataType="Double")
	private Double servicePay;
	/** 微信支付状态 */
	@ApiModelProperty(value="微信支付状态", dataType="Integer")
	private Integer wechatPayStatus;
	/** 微信订单号 */
	@ApiModelProperty(value="微信订单号", dataType="String")
	private String wechatOrderId;
	/** 微信退款单号 */
	@ApiModelProperty(value="微信退款单号", dataType="String")
	private String wechatRefundId;
	/** 服务评价星级 */
	@ApiModelProperty(value="服务评价星级", dataType="Integer")
	private Integer serviceStars;
	/** 服务后图片 */
	@ApiModelProperty(value="服务后图片", dataType="String")
	private String servicePictures;
	/** 服务后备注 */
	@ApiModelProperty(value="服务后备注", dataType="String")
	private String serviceRemark;
	@ApiModelProperty(value="联系电话", dataType="String")
	private String mobile;
	@ApiModelProperty(value="真实姓名", dataType="String")
	private String name;

	private ZhongzHouse house;

	public ZhongzHouse getHouse() {
		return house;
	}

	public void setHouse(ZhongzHouse house) {
		this.house = house;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderDayOrder() {
		return orderDayOrder;
	}

	public void setOrderDayOrder(Integer orderDayOrder) {
		this.orderDayOrder = orderDayOrder;
	}

	public void setOrderType(Integer orderType)
	{
		this.orderType = orderType;
	}

	public Integer getOrderType() 
	{
		return orderType;
	}
	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	public void setOrderStatus(Integer orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() 
	{
		return orderStatus;
	}
	public void setOrderTime(Date orderTime) 
	{
		this.orderTime = orderTime;
	}

	public Date getOrderTime() 
	{
		return orderTime;
	}
	public void setHouseId(String houseId) 
	{
		this.houseId = houseId;
	}

	public String getHouseId() 
	{
		return houseId;
	}
	public void setTenantId(String tenantId) 
	{
		this.tenantId = tenantId;
	}

	public String getTenantId() 
	{
		return tenantId;
	}
	public void setRenterId(String renterId) 
	{
		this.renterId = renterId;
	}

	public String getRenterId() 
	{
		return renterId;
	}
	public void setAcceptTime(Date acceptTime) 
	{
		this.acceptTime = acceptTime;
	}

	public Date getAcceptTime() 
	{
		return acceptTime;
	}
	public void setRequestServiceType(Integer requestServiceType) 
	{
		this.requestServiceType = requestServiceType;
	}

	public Integer getRequestServiceType() 
	{
		return requestServiceType;
	}
	public void setServiceDescription(String serviceDescription) 
	{
		this.serviceDescription = serviceDescription;
	}

	public String getServiceDescription() 
	{
		return serviceDescription;
	}
	public void setPictures(String pictures) 
	{
		this.pictures = pictures;
	}

	public String getPictures() 
	{
		return pictures;
	}
	public void setServerId(String serverId) 
	{
		this.serverId = serverId;
	}

	public String getServerId() 
	{
		return serverId;
	}
	public void setServerMobile(String serverMobile) 
	{
		this.serverMobile = serverMobile;
	}

	public String getServerMobile() 
	{
		return serverMobile;
	}
	public void setServicePay(Double servicePay) 
	{
		this.servicePay = servicePay;
	}

	public Double getServicePay() 
	{
		return servicePay;
	}
	public void setWechatPayStatus(Integer wechatPayStatus) 
	{
		this.wechatPayStatus = wechatPayStatus;
	}

	public Integer getWechatPayStatus() 
	{
		return wechatPayStatus;
	}
	public void setWechatOrderId(String wechatOrderId) 
	{
		this.wechatOrderId = wechatOrderId;
	}

	public String getWechatOrderId() 
	{
		return wechatOrderId;
	}
	public void setWechatRefundId(String wechatRefundId) 
	{
		this.wechatRefundId = wechatRefundId;
	}

	public String getWechatRefundId() 
	{
		return wechatRefundId;
	}
	public void setServiceStars(Integer serviceStars) 
	{
		this.serviceStars = serviceStars;
	}

	public Integer getServiceStars() 
	{
		return serviceStars;
	}
	public void setServicePictures(String servicePictures) 
	{
		this.servicePictures = servicePictures;
	}

	public String getServicePictures() 
	{
		return servicePictures;
	}
	public void setServiceRemark(String serviceRemark) 
	{
		this.serviceRemark = serviceRemark;
	}

	public String getServiceRemark() 
	{
		return serviceRemark;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderType", getOrderType())
            .append("orderId", getOrderId())
            .append("orderStatus", getOrderStatus())
            .append("orderTime", getOrderTime())
            .append("houseId", getHouseId())
            .append("tenantId", getTenantId())
            .append("renterId", getRenterId())
            .append("acceptTime", getAcceptTime())
            .append("requestServiceType", getRequestServiceType())
            .append("serviceDescription", getServiceDescription())
            .append("pictures", getPictures())
            .append("serverId", getServerId())
            .append("serverMobile", getServerMobile())
            .append("servicePay", getServicePay())
            .append("wechatPayStatus", getWechatPayStatus())
            .append("wechatOrderId", getWechatOrderId())
            .append("wechatRefundId", getWechatRefundId())
            .append("serviceStars", getServiceStars())
            .append("servicePictures", getServicePictures())
            .append("serviceRemark", getServiceRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
