package com.xiaoxing.springframwork02.factory.support;

import com.xiaoxing.springframwork02.BeansException;
import com.xiaoxing.springframwork02.factory.BeanDefinition;
import com.xiaoxing.springframwork02.factory.BeanFactory;

/**
 * @author xxhstart
 * @create 2022-02-10 22:23
 * @description: beanFactory抽象类,实现beanFactory基本接口，
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object singletonBean = getSingleton(name);
        if (singletonBean!=null){
            return singletonBean;
        }
        //如果没有就要从beanDefinition中新建一个，并且返回一个实例
        BeanDefinition beanDefinition = getBeanDefinition(name);
        //这一步是为什么？
        return createBean(name,beanDefinition);
    }

    /**
     * 根据bean名字获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String name)throws BeansException;

    /**
     * 根据beanName和bean定义创建bean
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition)throws BeansException;




}
