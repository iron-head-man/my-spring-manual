package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author xxhstart
 * @create 2022-02-17 22:40
 * @description: 实例化策略接口
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String name, Constructor cons, Object[] args)throws BeanException;

}
