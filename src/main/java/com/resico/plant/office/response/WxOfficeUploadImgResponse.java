package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.xml.soap.SAAJResult;
import java.io.Serializable;

@Data
@ApiModel("微信公众号上传图片")
public class WxOfficeUploadImgResponse implements Serializable {

    @ApiModelProperty("图片地址")
    private String url;

}
