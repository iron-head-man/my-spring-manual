package com.xiaoxing.springframwork15.aop;

import com.xiaoxing.springframwork15.util.ClassUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-13 15:21
 */
public class TargetSource {


    // 1、获取目标对象，获取目标对象interfaces
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        // cglib使用的是继承实现动态代理，jdk使用的是实现接口来生成代理类
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
