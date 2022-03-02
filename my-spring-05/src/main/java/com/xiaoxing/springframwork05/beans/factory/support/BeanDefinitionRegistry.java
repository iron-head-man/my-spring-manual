package com.xiaoxing.springframwork05.beans.factory.support;


import com.xiaoxing.springframwork05.beans.factory.config.BeanDefinition;

/**
 * @author xxhstart
 * @create 2022-02-21 10:54
 * @description: Bean注册
 */
public interface BeanDefinitionRegistry {

    /**
     *向注册表中注册 BeanDefinition
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
