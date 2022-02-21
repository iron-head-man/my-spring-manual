package com.xiaoxing.springframwork03.beans.factory.support;

import com.xiaoxing.springframwork03.beans.BeanException;
import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;

import java.beans.Beans;
import java.lang.reflect.Constructor;

/**
 * @author xxhstart
 * @create 2022-02-16 22:57
 * @description: 实现bean注入的bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeanException {

        Object bean = null;
        try {
            bean = createBeanInstance(name, beanDefinition, args);

        } catch (Exception e) {
            throw new BeanException("the creation of bean is failed");
        }
        addSingleton(name,bean);
        return bean;
    }

    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) {
        //采用反射构造一个带参数的bean
        //1.准备一个构造器
        Constructor constructorToUse = null;
        //2.拿到bean定义中的类信息
        Class clazz = beanDefinition.getClazz();
        //3.拿到bean对应类的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        //4.遍历构造器
        for (Constructor cons : declaredConstructors) {
            //TODO 思考：只是参数个数一样就返回这个构造器合理吗？？？
            if (args!=null && cons.getParameterTypes().length==args.length){
                constructorToUse = cons;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy(){return instantiationStrategy;}

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
