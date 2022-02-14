package com.xiaoxing.springframwork02.factory.support;

import com.xiaoxing.springframwork02.BeansException;
import com.xiaoxing.springframwork02.factory.BeanDefinition;

/**
 * @author xxhstart
 * @create 2022-02-10 23:24
 * @description: 抽象类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {

        Object bean;
        //用反射创建bean
        try {
            bean = beanDefinition.getClazz().newInstance();
            System.out.println("****");
        }catch (Exception e){

            throw new BeansException("instantiation of bean is failed");

        }
        addSingleton(beanName,bean);

        return bean;
    }
}




