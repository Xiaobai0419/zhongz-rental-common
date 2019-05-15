package com.zhongz.rental.result.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Result<T> {
    @ApiModelProperty(value="成功/失败", dataType="Boolean")
    private Boolean success = true;
    @ApiModelProperty(value="返回状态码", dataType="Integer")
    private Integer resultCode = 200;
    @ApiModelProperty(value="返回提示信息", dataType="String")
    private String message = "";
    @ApiModelProperty(value="页码", dataType="Integer")
    private Integer pageNum = 1;
    @ApiModelProperty(value="每页条数", dataType="Integer")
    private Integer pageSize = 10;
    @ApiModelProperty(value="总条数", dataType="Integer")
    private Integer totalNum = 0;
    @ApiModelProperty(value="总页数", dataType="Integer")
    private Integer totalPage = 0;
    private List<T> data;

    public Result() {

    }
    public Result(Integer pageNum,Integer pageSize,Integer totalNum,List<T> data) {
        this.pageNum = (pageNum == null || pageNum < 1) ? 1 : pageNum;
        this.pageSize = (pageSize == null || pageSize < 1) ? 10: pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum%this.pageSize == 0) ? this.totalNum/this.pageSize : (this.totalNum/this.pageSize + 1);
        this.data = data;
    }
}
