package com.resico.plant.office.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Airey
 * @since 2022/4/27 17:17
 */
@Data
@ApiModel("微信公众号删除群发消息返回")
public class WxOfficeDeleteMsgResponse implements Serializable {

    @ApiModelProperty("错误码")
    private Integer errcode;


    @ApiModelProperty("错误信息")
    private String errmsg;


}
