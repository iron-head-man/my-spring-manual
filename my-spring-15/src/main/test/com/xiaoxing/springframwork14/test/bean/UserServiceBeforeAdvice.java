package com.xiaoxing.springframwork15.test.bean;

import com.xiaoxing.springframwork15.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-25 11:17
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
