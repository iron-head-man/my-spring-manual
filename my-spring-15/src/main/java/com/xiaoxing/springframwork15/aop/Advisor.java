package com.xiaoxing.springframwork15.aop;

import org.aopalliance.aop.Advice;

/**
 * <p>
 * 定义访问者
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-20 22:21
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
