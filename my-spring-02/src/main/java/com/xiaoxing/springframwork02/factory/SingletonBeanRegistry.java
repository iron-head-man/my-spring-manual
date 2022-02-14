package com.xiaoxing.springframwork02.factory;


/**
 * @author xxhstart
 * @create 2022-02-10 18:39
 * @description: 单例bean注册
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例bean
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
