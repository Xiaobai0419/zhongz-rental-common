package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 优惠券策略表 zhongz_coupon_policy
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@ApiModel(value="ZhongzCouponPolicy", description="")
public class ZhongzCouponPolicy extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
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
            .append("titile", getTitile())
            .append("name", getName())
            .append("preference", getPreference())
            .append("rules", getRules())
            .append("expire", getExpire())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
