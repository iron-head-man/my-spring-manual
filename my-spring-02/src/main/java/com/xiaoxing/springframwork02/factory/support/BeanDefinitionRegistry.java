package com.xiaoxing.springframwork02.factory.support;


import com.xiaoxing.springframwork02.factory.BeanDefinition;

/**
 * @author xxhstart
 * @create 2022-02-10 22:34
 * @description: 注册表
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

