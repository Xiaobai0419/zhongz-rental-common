package com.zhongz.rental.result;

import com.zhongz.rental.result.base.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="WechatPrePayResult", description="")
public class WechatPrePayResult extends Result {
    @ApiModelProperty(value="预支付交易会话ID", dataType="String")
    private String prepayid;
    @ApiModelProperty(value="商户号", dataType="String")
    private String partnerid;
    @ApiModelProperty(value="随机字符串", dataType="String")
    private String noncestr;
    @ApiModelProperty(value="签名", dataType="String")
    private String sign;
    @ApiModelProperty(value="时间戳", dataType="Long")
    private Long timestamp;
}