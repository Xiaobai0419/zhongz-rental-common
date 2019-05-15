package com.zhongz.rental.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 优惠券表 zhongz_coupon
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@ApiModel(value="ZhongzCoupon", description="")
public class ZhongzCoupon extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 优惠券编码 */
	@ApiModelProperty(value="优惠券编码", dataType="String")
	private String code;
	/** 优惠券类型 */
	@ApiModelProperty(value="优惠券类型 1 新用户欢迎礼 2 老带新优惠 3 老客户续租优惠", dataType="String")
	private String policyId;
	/** 归属用户 */
	@ApiModelProperty(value="归属用户", dataType="String")
	private String userId;
	/** 优惠券状态 */
	@ApiModelProperty(value="优惠券状态", dataType="Integer")
	private Integer status;
	/** 获取时间 */
	@ApiModelProperty(value="获取时间", dataType="Date")
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8"
	)
	private Date achieveTime;
	/** 使用时间 */
	@ApiModelProperty(value="使用时间", dataType="Date")
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8"
	)
	private Date useTime;
	/** 使用去向 */
	@ApiModelProperty(value="使用去向", dataType="String")
	private String houseId;
	/** 优惠标题 */
	@ApiModelProperty(value="优惠标题", dataType="String")
	private String titile;
	/** 优惠信息 */
	@ApiModelProperty(value="优惠信息", dataType="String")
	private String name;
	/** 优惠力度 */
	@ApiModelProperty(value="优惠力度", dataType="Double")
	private Double preference;
	/** 使用规则 */
	@ApiModelProperty(value="使用规则", dataType="String")
	private String rules;
	/** 有效期限 */
	@ApiModelProperty(value="有效期限", dataType="Integer")
	private Integer expire;

	@ApiModelProperty(value="优惠房屋", dataType="Integer")
	private ZhongzHouse house;

	public ZhongzHouse getHouse() {
		return house;
	}

	public void setHouse(ZhongzHouse house) {
		this.house = house;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	public void setPolicyId(String policyId) 
	{
		this.policyId = policyId;
	}

	public String getPolicyId() 
	{
		return policyId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setAchieveTime(Date achieveTime) 
	{
		this.achieveTime = achieveTime;
	}

	public Date getAchieveTime() 
	{
		return achieveTime;
	}
	public void setUseTime(Date useTime) 
	{
		this.useTime = useTime;
	}

	public Date getUseTime() 
	{
		return useTime;
	}
	public void setHouseId(String houseId) 
	{
		this.houseId = houseId;
	}

	public String getHouseId() 
	{
		return houseId;
	}

	public void setTitile(String titile)
	{
		this.titile = titile;
	}

	public String getTitile() 
	{
		return titile;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setPreference(Double preference) 
	{
		this.preference = preference;
	}

	public Double getPreference() 
	{
		return preference;
	}
	public void setRules(String rules) 
	{
		this.rules = rules;
	}

	public String getRules() 
	{
		return rules;
	}
	public void setExpire(Integer expire) 
	{
		this.expire = expire;
	}

	public Integer getExpire() 
	{
		return expire;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("policyId", getPolicyId())
            .append("userId", getUserId())
            .append("status", getStatus())
            .append("achieveTime", getAchieveTime())
            .append("useTime", getUseTime())
            .append("houseId", getHouseId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .append("titile", getTitile())
            .append("name", getName())
            .append("preference", getPreference())
            .append("rules", getRules())
            .append("expire", getExpire())
            .toString();
    }
}
