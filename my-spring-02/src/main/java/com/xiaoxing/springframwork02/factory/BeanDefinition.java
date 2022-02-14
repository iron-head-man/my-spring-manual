package com.xiaoxing.springframwork02.factory;


/**
 * @author xxhstart
 * @create 2022-02-10 18:37
 * @description: bean定义
 */
public class BeanDefinition {

    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }
}
