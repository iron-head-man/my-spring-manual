package com.xiaoxing.springframwork;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xxhstart
 * @create 2022-02-10 16:52
 * @description:Bean工厂，bean的注册和get
 */
public class BeanFactory {

    Map<String,BeanDefine> map = new ConcurrentHashMap<>();

    //注册bean
    public void pushBean(String name,BeanDefine bean){
        map.put(name,bean);
    }

    //通过name获取bean实例
    public Object getBean(String name){
        //这里为什么要返回beanDefine的具体bean属性？
        Object bean = map.get(name).getBean();
        return bean;
    }
}
