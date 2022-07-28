package com.xiaoxing.springframwork14.context.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-27 0:01
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
