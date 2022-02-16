package com.xiaoxing.springframwork03.beans.factory.config;

/**
 * @author xxhstart
 * @create 2022-02-16 22:12
 * @description: Bean定义管理
 */
public class BeanDefinition {

    private Class clazz;

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
