package com.zhongz.rental.param;

import com.zhongz.rental.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户预约 zhongz_user
 * 
 * @author ruoyi
 * @date 2019-04-15
 */
@Data
@ApiModel(value="ZhongzUserParam", description="")
public class ZhongzUserOrderParam extends BaseParam
{
	/** 微信小程序用户唯一标识 */
	@ApiModelProperty(value="微信小程序用户唯一标识", dataType="String")
	private String openid;
	/** 微信小程序用户会话密钥 */
	@ApiModelProperty(value="微信小程序用户会话密钥", dataType="String")
	private String sessionKey;
	/** 房屋id */
	@ApiModelProperty(value="房屋id", dataType="String")
	private String houseId;
	@ApiModelProperty(value="用户昵称", dataType="String")
	private String nickName;
	@ApiModelProperty(value="头像url", dataType="String")
	private String headPortrait;
}
