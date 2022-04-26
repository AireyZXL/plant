package com.resico.plant.office.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Airey
 * @since 2022/4/22 14:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles implements Serializable {


    @ApiModelProperty("图文消息列表")
    List<News> articles;

}
