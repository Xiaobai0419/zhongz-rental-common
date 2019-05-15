package com.zhongz.rental.returnParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="ZhongzUserInvitedReturnParam", description="")
@Data
public class ZhongzUserInvitedReturnParam {
    @ApiModelProperty(value="用户id", dataType="String")
    private String id;
    @ApiModelProperty(value="签约合同id", dataType="String")
    private String cid;
}
