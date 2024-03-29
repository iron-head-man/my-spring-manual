package com.xiaoxing.springframwork15.aop.framwork.autoproxy;

import java.util.Collection;

import com.xiaoxing.springframwork15.aop.*;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import com.xiaoxing.springframwork15.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.xiaoxing.springframwork15.aop.framwork.ProxyFactory;
import com.xiaoxing.springframwork15.beans.BeansException;
import com.xiaoxing.springframwork15.beans.PropertyValues;
import com.xiaoxing.springframwork15.beans.factory.BeanFactory;
import com.xiaoxing.springframwork15.beans.factory.BeanFactoryAware;
import com.xiaoxing.springframwork15.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.xiaoxing.springframwork15.beans.factory.support.DefaultListableBeanFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-21 22:07
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isInfrastructureClass(bean.getClass()))
            return bean;
        // 拿到所有切面
        Collection<AspectJExpressionPointcutAdvisor> advisors =
                        beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(bean.getClass()))
                continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(bean.getClass().getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            return new ProxyFactory(advisedSupport).getProxy();
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
                    throws BeansException {
        return pvs;
    }

    // beanClass是 advice的子类，子接口，或者是切点子接口子类，访问者的子类子接口
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass)
                        || Advisor.class.isAssignableFrom(beanClass);
    }
}
