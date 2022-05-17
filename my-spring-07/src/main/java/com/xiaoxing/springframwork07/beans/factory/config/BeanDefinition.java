package com.xiaoxing.springframwork07.beans.factory.config;

import com.xiaoxing.springframwork07.beans.PropertyValues;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！ 公众号：bugstack虫洞栈 Create by 小傅哥(fustack)
 * 
 * 
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;



//    在 BeanDefinition 新增加了两个属性：initMethodName、destroyMethodName，
//    这两个属性是为了在 spring.xml 配置的Bean 对象中，
//    可以配置 initmethod = "initDataMethod"destroymethod="destroyDataMethod"操作，最终实现接口的效果是一样的。
//    只不 过一个是接口方法的直接调用，另外是一个在配置文件中读取到方法反射调用

    private String initMethodName;

    private String destroyMethodName;


    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
