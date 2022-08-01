package com.xiaoxing.springframwork15.aop;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-20 22:23
 */
public interface PointcutAdvisor extends Advisor{

    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
