package com.zhongz.rental.result;

import com.zhongz.rental.domain.ZhongzUser;
import com.zhongz.rental.result.base.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="LoginResult", description="")
public class LoginResult extends Result {

    @ApiModelProperty(value="返回用户信息", dataType="ZhongzUser")
    private ZhongzUser user;
}