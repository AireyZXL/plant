package com.resico.plant.office.response;

import com.resico.plant.office.model.Draft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("获取草稿返回对象")
public class WxOfficeDraftDetailResponse implements Serializable {

    @ApiModelProperty("草稿列表")
    private List<Draft> news_item;


}
