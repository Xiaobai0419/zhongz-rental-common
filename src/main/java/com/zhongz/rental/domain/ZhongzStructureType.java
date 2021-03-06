package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 户型表 zhongz_structure_type
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@ApiModel(value="ZhongzStructureType", description="")
public class ZhongzStructureType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 类型值 */
	@ApiModelProperty(value="类型值", dataType="Integer")
	private Integer typeCode;
	/** 类型描述 */
	@ApiModelProperty(value="类型描述", dataType="String")
	private String typeName;

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

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeCode", getTypeCode())
            .append("typeName", getTypeName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
