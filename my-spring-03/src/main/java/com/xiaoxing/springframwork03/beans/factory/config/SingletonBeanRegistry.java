package com.xiaoxing.springframwork03.beans.factory.config;

/**
 * @author xxhstart
 * @create 2022-02-16 22:13
 * @description:获取单例顶级接口
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例
     * @param beanName
     * @return
     */
    public Object getSingleton(String beanName);
}
