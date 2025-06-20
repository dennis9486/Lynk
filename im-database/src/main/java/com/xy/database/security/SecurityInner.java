package com.xy.database.security;

import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SecurityInner {
    /**
     * 是否AOP统一处理(可以理解为是否仅允许Feign之间调用)
     *
     * @return false, true
     */
    boolean value() default true;

    /**
     * 需要特殊判空的字段(预留)
     *
     * @return {}
     */
    String[] field() default {};
}