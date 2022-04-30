package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("微信群发消息状态返回")
public class WxOfficeSendStatusResponse implements Serializable {

    @ApiModelProperty("群发消息后返回的消息id")
    private String msg_id;

    @ApiModelProperty("消息发送后的状态，SEND_SUCCESS表示发送成功，SENDING表示发送中，SEND_FAIL表示发送失败，DELETE表示已删除")
    private String msg_status;

}
