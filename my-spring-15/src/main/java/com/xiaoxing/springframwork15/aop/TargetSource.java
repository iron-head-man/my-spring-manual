package com.xiaoxing.springframwork15.aop;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-13 15:21
 */
public class TargetSource {


    //1、获取目标对象，获取目标对象interfaces

    private final Object target;


    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
