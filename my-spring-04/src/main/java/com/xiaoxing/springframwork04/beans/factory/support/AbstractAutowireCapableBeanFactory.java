package com.xiaoxing.springframwork04.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;

import com.xiaoxing.springframwork04.beans.BeanException;
import com.xiaoxing.springframwork04.beans.PropertyValue;
import com.xiaoxing.springframwork04.beans.PropertyValues;
import com.xiaoxing.springframwork04.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork04.beans.factory.config.BeanReference;

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
            //创建实例
            bean = createBeanInstance(name, beanDefinition, args);
            //注入属性
            applyPropertyValues(name, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeanException("the creation of bean is failed");
        }
        addSingleton(name, bean);
        return bean;
    }

    /***
     * <p>
     * 注入属性
     * </p>
     * @param beanName:
     * @param bean:
     * @param beanDefinition:
     * @return: void
     * @author heng.xing@hand-china.com 2022/2/28 22:12
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    //a依赖b,递归获取b的实例对象、、TODO 循环依赖？？
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //hutool的工具类--->object类用反射设置值
                BeanUtil.setFieldValue(bean, name, value);
            }

        } catch (Exception e) {
            throw new BeanException("Error setting properties of bean#" + beanName + "#");
        }
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
            if (args != null && cons.getParameterTypes().length == args.length) {
                constructorToUse = cons;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
