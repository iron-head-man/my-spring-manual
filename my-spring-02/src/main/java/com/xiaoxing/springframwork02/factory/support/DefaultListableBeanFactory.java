package com.xiaoxing.springframwork02.factory.support;

import com.xiaoxing.springframwork02.BeansException;
import com.xiaoxing.springframwork02.factory.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxhstart
 * @create 2022-02-14 21:26
 * @description: 核心实现类
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private final Map<String,BeanDefinition> map = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String name) throws BeansException {
        BeanDefinition beanDefinition = map.get(name);
        if (beanDefinition==null){
            throw new BeansException("no bean named:"+name+"is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        map.put(beanName,beanDefinition);
    }
}
