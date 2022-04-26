package com.resico.plant.office.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("微信token请求")
public class WxOfficeTokenRequest implements Serializable {


    @ApiModelProperty("grant_type")
    private String grant_type;

    @ApiModelProperty("appid")
    private String appid;

    @ApiModelProperty("app秘钥")
    private String secret;


}
