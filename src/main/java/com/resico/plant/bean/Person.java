package com.resico.plant.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Airey
 * @date 2021/2/26 10:17
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer age;

    private String name;

    private String address;


}
