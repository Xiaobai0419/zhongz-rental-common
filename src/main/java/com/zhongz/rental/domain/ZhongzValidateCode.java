package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 验证码表 zhongz_validate_code
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@ApiModel(value="ZhongzValidateCode", description="")
public class ZhongzValidateCode extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 类型 */
	@ApiModelProperty(value="类型", dataType="Integer")
	private Integer type = 0;
	/** 验证手机 */
	@ApiModelProperty(value="验证手机", dataType="String")
	private String mobile;
	/** 验证码 */
	@ApiModelProperty(value="验证码", dataType="String")
	private String code;
	/** 有效期 */
	@ApiModelProperty(value="有效期", dataType="Integer")
	private Integer expire = 60;

	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
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
            .append("type", getType())
            .append("mobile", getMobile())
            .append("code", getCode())
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
