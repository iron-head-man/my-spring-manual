package com.xiaoxing.springframwork14.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * <p>
 ** Annotation at the field or method/constructor parameter level
 *  * that indicates a default value expression for the affected argument.
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-28 23:50
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
