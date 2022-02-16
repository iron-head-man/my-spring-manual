package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxhstart
 * @create 2022-02-16 22:16
 * @description: 注册bean默认实现类
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    Map<String,Object> map = new HashMap();

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }

    public void addSingleton(String name,Object singletonObject){
        map.put(name,singletonObject);
    }

}
