package com.xiaoxing.springframwork08.beans.factory;

import com.xiaoxing.springframwork07.beans.BeansException;
import com.xiaoxing.springframwork07.beans.factory.config.AutowireCapableBeanFactory;
import com.xiaoxing.springframwork07.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork07.beans.factory.config.BeanPostProcessor;
import com.xiaoxing.springframwork07.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
