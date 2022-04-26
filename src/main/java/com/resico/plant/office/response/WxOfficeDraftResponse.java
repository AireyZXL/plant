package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("微信公众号创建草稿")
public class WxOfficeDraftResponse implements Serializable {


    @ApiModelProperty("上传后的获取标志，长度不固定，但不会超过 128 字符")
    private String media_id;

}
