package com.zhongz.rental.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 请求服务类型表 zhongz_request_service_type
 * 
 * @author ruoyi
 * @date 2019-05-07
 */
public class ZhongzRequestServiceType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 服务大类 */
	private Integer type;
	/** 类型值 */
	private Integer typeCode;
	/** 类型描述 */
	private String typeName;

	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
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
            .append("type", getType())
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
