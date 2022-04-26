package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("微信公众号群发消息返回")
public class WxOfficeSendToAllResponse implements Serializable {


    @ApiModelProperty("媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息为news")
    private String type;

    @ApiModelProperty("错误码")
    private String errcode;

    @ApiModelProperty("错误信息")
    private String errmsg;

    @ApiModelProperty("消息发送任务的ID")
    private String msg_id;

    @ApiModelProperty("消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。")
    private String msg_data_id;


}
