package com.zhongz.rental.param;

import com.zhongz.rental.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="ZhongzHouseParam", description="")
public class ZhongzHouseParam extends BaseParam {

    @ApiModelProperty(value="搜索关键字（小区名或地名）", dataType="String")
    private String keyWord;

    @ApiModelProperty(value="搜索整租房源，传1", dataType="Integer")
    private Integer solo;

    @ApiModelProperty(value="搜索合租房源，传1", dataType="Integer")
    private Integer joint;

    @ApiModelProperty(value="整租房源户型，传户型type_code字段（整型），多选，不限不传")
    private List<Integer> soloStructures;

    @ApiModelProperty(value="合租房源户型，传户型type_code字段（整型），多选，不限不传")
    private List<Integer> jointStructures;

    @ApiModelProperty(value="小区id", dataType="String")
    private String estateId;

    @ApiModelProperty(value="租金下限", dataType="Integer")
    private Integer rentFloor;

    @ApiModelProperty(value="租金上限", dataType="Integer")
    private Integer rentCeil;

    @ApiModelProperty(value="热度标签id集合，多选")
    private List<String> tagIds;

    @ApiModelProperty(value="排序规则：默认1，按热度；2，按价格低到高；3，按价格高到低" +
            "4，按面积低到高；5，按面积高到低", dataType="Integer")
    private Integer orderBy = 1;//默认1，默认按热度、更新时间排序

    @ApiModelProperty(value="宣传活动id，通栏广告指定活动的房源", dataType="String")
    private String eventId;

    private List<String> houseIds;
}
