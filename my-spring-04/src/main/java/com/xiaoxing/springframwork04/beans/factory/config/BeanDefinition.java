package com.xiaoxing.springframwork04.beans.factory.config;

import com.xiaoxing.springframwork04.beans.PropertyValues;

/**
 * <p>
 * 类定义类
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 21:29
 */
public class BeanDefinition {

    private Class clazz;
    //新的属性值
    private PropertyValues propertyValues;


    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class clazz, PropertyValues propertyValues) {
        this.clazz = clazz;
        this.propertyValues= propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
