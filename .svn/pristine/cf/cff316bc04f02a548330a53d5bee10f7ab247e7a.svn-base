package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管家留言表 zhongz_comment
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@ApiModel(value="ZhongzComment", description="")
public class ZhongzComment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 留言者id */
	@ApiModelProperty(value="留言者id", dataType="String")
	private String userId;
	/** 真实姓名 */
	@ApiModelProperty(value="真实姓名", dataType="String")
	private String name;
	/** 联系电话 */
	@ApiModelProperty(value="联系电话", dataType="String")
	private String mobile;
	/** 留言内容 */
	@ApiModelProperty(value="留言内容", dataType="String")
	private String content;
	/** 微信小程序用户唯一标识 */
	@ApiModelProperty(value="微信小程序用户唯一标识", dataType="String")
	private String openid;
	/** 微信小程序用户会话密钥 */
	@ApiModelProperty(value="微信小程序用户会话密钥", dataType="String")
	private String sessionKey;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("name", getName())
            .append("mobile", getMobile())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
