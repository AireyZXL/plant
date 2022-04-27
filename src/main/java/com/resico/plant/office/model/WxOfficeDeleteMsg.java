package com.resico.plant.office.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Airey
 * @since 2022/4/27 17:11
 */
@Data
@ApiModel("删除群发消息")
public class WxOfficeDeleteMsg implements Serializable {


    @ApiModelProperty("发送出去的消息ID")
    private String msg_id;


    @ApiModelProperty("要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章")
    private Integer article_idx;


}
