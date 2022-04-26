package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("上传图文消息返回")
public class WxOfficeUploadNewsResponse implements Serializable {


    @ApiModelProperty("媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）")
    private String type;

    @ApiModelProperty("媒体文件/图文消息上传后获取的唯一标识")
    private String media_id;

    @ApiModelProperty("媒体文件上传时间")
    private String created_at;






}
