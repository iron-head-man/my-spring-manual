package com.xiaoxing.springframwork02.factory.support;

import com.xiaoxing.springframwork02.factory.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxhstart
 * @create 2022-02-10 22:26
 * @description: 单例bean注册默认实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String,Object> map = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }

    public void addSingleton(String beanName,Object singletonObject){
        map.put(beanName,singletonObject);
    }
}
