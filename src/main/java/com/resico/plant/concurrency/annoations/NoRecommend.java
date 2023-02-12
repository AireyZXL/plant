package com.resico.plant.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Airey
 * @date 2023/2/2 17:48
 * 课程里用来不推荐写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NoRecommend {


    String value() default "";
    
}
