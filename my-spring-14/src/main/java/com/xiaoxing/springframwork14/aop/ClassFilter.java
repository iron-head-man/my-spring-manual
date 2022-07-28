package com.xiaoxing.springframwork14.aop;

/**
 * <p>
 *  定义类匹配类，用于切点找到给定的接口和目标类。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-13 14:15
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
