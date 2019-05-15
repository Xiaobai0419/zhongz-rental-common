package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 租赁时长类别表 zhongz_rent_type
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@ApiModel(value="ZhongzRentType", description="")
public class ZhongzRentType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 类型值 */
	@ApiModelProperty(value="类型值", dataType="Integer")
	private Integer typeCode;
	/** 类型描述 */
	@ApiModelProperty(value="类型描述", dataType="String")
	private String typeName;
	/** 租赁按月时长 */
	@ApiModelProperty(value="租赁按月时长", dataType="Integer")
	private Integer typePeriod;

	public void setTypeCode(Integer typeCode) 
	{
		this.typeCode = typeCode;
	}

	public Integer getTypeCode() 
	{
		return typeCode;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setTypePeriod(Integer typePeriod) 
	{
		this.typePeriod = typePeriod;
	}

	public Integer getTypePeriod() 
	{
		return typePeriod;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeCode", getTypeCode())
            .append("typeName", getTypeName())
            .append("typePeriod", getTypePeriod())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
