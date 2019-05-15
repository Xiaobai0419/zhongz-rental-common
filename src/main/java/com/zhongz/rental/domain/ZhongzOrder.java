package com.zhongz.rental.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 订单表 zhongz_order
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@ApiModel(value="ZhongzOrder", description="")
public class ZhongzOrder extends BaseEntity
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
	/** 合同表id */
	@ApiModelProperty(value="合同表id", dataType="String")
	private String contractId;

	/** 关联合同 */
	@ApiModelProperty(value="关联合同", dataType="ZhongzContract")
	private ZhongzContract contract;

	public ZhongzContract getContract() {
		return contract;
	}

	public void setContract(ZhongzContract contract) {
		this.contract = contract;
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
	public void setContractId(String contractId) 
	{
		this.contractId = contractId;
	}

	public String getContractId() 
	{
		return contractId;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderType", getOrderType())
            .append("orderId", getOrderId())
            .append("orderStatus", getOrderStatus())
            .append("orderTime", getOrderTime())
            .append("contractId", getContractId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
