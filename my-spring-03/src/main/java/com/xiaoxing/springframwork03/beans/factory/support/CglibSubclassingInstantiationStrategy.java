package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author xxhstart
 * @create 2022-02-21 10:06
 * @description: cglib实现实例化的方式
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor cons, Object[] args) throws BeanException {
        //cglib常用类，为目标类创建一个代理子类
        Enhancer enhancer = new Enhancer();
        //设置目标类为父类
        enhancer.setSuperclass(beanDefinition.getClazz());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == cons){
            return enhancer.create();
        }
        return enhancer.create(cons.getParameterTypes(),args);
    }
}
