package com.resico.plant.office;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @author Airey
 * @since 2022/4/22 11:02
 */
@ConfigurationProperties(prefix = "wx.office")
@Data
@Service
public class WxOfficeConfig {


    private String appId;


    private String secret;

    private String token;

}
