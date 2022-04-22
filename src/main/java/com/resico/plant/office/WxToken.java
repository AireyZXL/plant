package com.resico.plant.office;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author Airey
 * @since 2022/4/22 11:50
 */
@Data
public class WxToken implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private String expiresIn;

}
