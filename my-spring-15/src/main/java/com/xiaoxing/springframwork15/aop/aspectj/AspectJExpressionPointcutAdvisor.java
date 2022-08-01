package com.xiaoxing.springframwork15.aop.aspectj;

import com.xiaoxing.springframwork15.aop.Pointcut;
import com.xiaoxing.springframwork15.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-20 22:25
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut)
            pointcut = new AspectJExpressionPointcut(expression);
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public AspectJExpressionPointcutAdvisor setExpression(String expression) {
        this.expression = expression;
        return this;
    }
}
