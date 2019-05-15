package com.zhongz.rental.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管家表 zhongz_manager
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@ApiModel(value="ZhongzManager", description="")
public class ZhongzManager extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 在线状态 */
	@ApiModelProperty(value="在线状态", dataType="Integer")
	private Integer onlineState;
	/** 联系电话 */
	@ApiModelProperty(value="联系电话", dataType="String")
	private String phone;
	/** 短信接收手机 */
	@ApiModelProperty(value="短信接收手机", dataType="String")
	private String mobile;
	/** 第一段描述 */
	@ApiModelProperty(value="第一段描述", dataType="String")
	private String description1;
	/** 第二段描述 */
	@ApiModelProperty(value="第二段描述", dataType="String")
	private String description2;
	/** 微信二维码图片地址 */
	@ApiModelProperty(value="微信二维码图片地址", dataType="String")
	private String wechatQrcode;

	public String getWechatQrcode() {
		return wechatQrcode;
	}

	public void setWechatQrcode(String wechatQrcode) {
		this.wechatQrcode = wechatQrcode;
	}

	public void setOnlineState(Integer onlineState)
	{
		this.onlineState = onlineState;
	}

	public Integer getOnlineState() 
	{
		return onlineState;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setDescription1(String description1) 
	{
		this.description1 = description1;
	}

	public String getDescription1() 
	{
		return description1;
	}
	public void setDescription2(String description2) 
	{
		this.description2 = description2;
	}

	public String getDescription2() 
	{
		return description2;
	}

    @Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("onlineState", getOnlineState())
            .append("phone", getPhone())
            .append("mobile", getMobile())
            .append("description1", getDescription1())
            .append("description2", getDescription2())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status1", getStatus1())
            .toString();
    }
}
