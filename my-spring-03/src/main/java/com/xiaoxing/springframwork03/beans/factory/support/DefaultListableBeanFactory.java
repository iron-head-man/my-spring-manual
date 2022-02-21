package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxhstart
 * @create 2022-02-21 10:43
 * @description: 核心实现类
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map map = new HashMap<String,BeanDefinition>();

    @Override
    protected BeanDefinition getBeanDefinition(String name) throws BeanException {
        return (BeanDefinition)map.get(name);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        map.put(name,beanDefinition);
    }
}
