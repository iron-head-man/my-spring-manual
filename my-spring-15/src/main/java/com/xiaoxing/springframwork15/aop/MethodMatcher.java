package com.xiaoxing.springframwork15.aop;

import java.lang.reflect.Method;

/**
 * <p>
 *   * Filter that restricts matching of a pointcut or introduction to
 *  * a given set of target classes.
 *  方法匹配，找到表达式范围内匹配下的目标类和方法。在上文的案例中有所体现：methodMatcher.matches(method, targetObj.getClass())
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-13 14:15
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
