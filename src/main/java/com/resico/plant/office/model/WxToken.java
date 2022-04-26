package com.resico.plant.office.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author Airey
 * @since 2022/4/22 11:50
 */
@Data
@ApiModel("微信公众号授权对象")
public class WxToken implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("过期时间")
    private String expiresIn;

}
