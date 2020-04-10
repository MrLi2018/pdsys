package com.demo.pdsys.annotion;

import java.lang.annotation.*;

/**
 * @author MrLi2019
 * 是否需要经过token验证
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthByToken {
    boolean value() default false;
}
