package com.xiaoxing.springframwork13.context.support;

import com.xiaoxing.springframwork13.beans.BeansException;
import com.xiaoxing.springframwork13.beans.factory.config.BeanPostProcessor;
import com.xiaoxing.springframwork13.context.ApplicationContext;
import com.xiaoxing.springframwork13.context.ApplicationContextAware;

/**
 * <p>
 * 包装处理器\
 * 由于 ApplicationContext 的获取并不能直接在创建 Bean 时候就可以拿到，所以
 * 需要在 refresh 操作时，把 ApplicationContext 写入到一个包装的
 * BeanPostProcessor 中去，再由
 * AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization方法调用。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-07 21:35
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * <p>
     *  所有bean初始化之前的操作，如果bean实现了ApplicationContextAware接口，都能在类中获取到applicationContext
     * </p>
     * @param bean:
     * @param beanName:
     * @return java.lang.Object
     * @author heng.xing@hand-china.com 2022/6/7 21:53
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
