package com.xiaoxing.springframwork11.aop.framwork;

/**
 * <p>
 *  定义一个标准接口，用于获取代理类。因为具体实现代理的方式可以有 JDK 方式，也可以是 Cglib 方式，所以定义接口会更加方便管理实现类。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-13 15:37
 */
public interface AopProxy {

    /**
     * <p>
     * 获取代理类
     * </p>

     * @return java.lang.Object
     * @author heng.xing@hand-china.com 2022/6/13 15:39
     */
    Object getProxy();
}
