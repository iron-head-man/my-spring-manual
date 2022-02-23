package com.xiaoxing.springframwork04.beans.factory.support;

import com.xiaoxing.springframwork04.beans.BeanException;
import com.xiaoxing.springframwork04.beans.factory.BeanFactory;
import com.xiaoxing.springframwork04.beans.factory.config.BeanDefinition;

/**
 * <p>
 * 一级抽象类
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 22:15
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    //getBean的逻辑操作在这里


    @Override
    public Object getBean(String beanName) throws BeanException {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeanException {
        return doGetBean(beanName,args);
    }

    protected <T> T doGetBean(final String beanName,final Object[] args){
        Object singleton = getSingleton(beanName);
        if (singleton!=null){
            return (T)singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T)createBean(beanName,beanDefinition,args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
