package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("永久素材")
public class WxOfficePermanentMaterialResponse implements Serializable {


    @ApiModelProperty("新增的永久素材的media_id")
    private String media_id;

    @ApiModelProperty("新增的图片素材的图片URL（仅新增图片素材时会返回该字段）")
    private String url;

}
