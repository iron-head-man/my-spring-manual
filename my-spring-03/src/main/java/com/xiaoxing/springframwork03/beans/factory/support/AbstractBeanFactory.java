package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.BeanFactory;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;

/**
 * @author xxhstart
 * @create 2022-02-16 22:15
 * @description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, args);
    }

    //TODO 为何要用泛型??
    protected <T> T doGetBean(final String name, final Object[] args) {

        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name,beanDefinition,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String name)throws BeanException;

    protected abstract Object createBean(String name,BeanDefinition beanDefinition,Object[] args)throws BeanException;

}
