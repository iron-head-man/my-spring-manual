package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xxhstart
 * @create 2022-02-17 23:39
 * @description: JDK实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor cons, Object[] args) throws BeanException {
        //拿到类信息
        Class clazz = beanDefinition.getClazz();
        try {
            //如果构造器不为空
            if (cons != null) {
                return clazz.getDeclaredConstructor(cons.getParameterTypes()).newInstance(args);
            } else {
                //传入构造器为空，返回一个
                return clazz.getDeclaredConstructor().newInstance();
            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException
                e) {
            throw new BeanException("failed to instantiate {" + clazz.getName() + "}");
        }


    }
}
