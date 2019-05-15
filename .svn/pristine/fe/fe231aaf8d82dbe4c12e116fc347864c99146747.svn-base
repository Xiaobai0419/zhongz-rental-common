package com.zhongz.rental.param.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="BaseParam", description="")
public class BaseParam {
    @ApiModelProperty(value="页码", dataType="Integer")
    private Integer pageNum = 1;
    @ApiModelProperty(value="每页条数", dataType="Integer")
    private Integer pageSize = 10;
    private Integer limitStart = 0;
    private Integer limitNum = 10;

    public void genMysqlPage() {
        if(pageNum != null && pageSize != null) {
            //分页参数
            Integer limitStart = (pageNum - 1) * pageSize;
            limitStart = (limitStart < 0 ? 0 : limitStart);
            Integer limitNum = pageSize;
            limitNum = (limitNum < 1 ? 10 : limitNum);
            this.limitStart = limitStart;
            this.limitNum = limitNum;
        }

    }
}
