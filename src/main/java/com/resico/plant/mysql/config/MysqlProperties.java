package com.resico.plant.mysql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @author Airey
 * @since 2022/3/29 14:45
 */
@Service
@ConfigurationProperties(prefix = "mysql")
@Data
public class MysqlProperties {

    private String dbUrl;

    private String dbName;

    private String userName;

    private String password;


}
