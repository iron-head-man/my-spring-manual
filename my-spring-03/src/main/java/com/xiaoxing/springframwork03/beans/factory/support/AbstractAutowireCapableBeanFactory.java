package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author xxhstart
 * @create 2022-02-16 22:57
 * @description: 实现bean注入的bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeanException {

        Object bean = null;

        try {
            createBeanInstance(name, beanDefinition, args);

        } catch (Exception e) {
            throw new BeanException("the creation of bean is failed");
        }


        return null;
    }

    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) {
        //采用反射构造一个带参数的bean
        //1.准备一个构造器
        Constructor constructorToUse = null;
        Class clazz = beanDefinition.getClazz();

        return null;
    }
}
