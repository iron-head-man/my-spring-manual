package com.xiaoxing.springframwork09.beans.factory;

/**
 * <p>
 *  InitializingBean、DisposableBean，两个接口方法还是比较常用的，在一些需要结
 * 合 Spring 实现的组件中，经常会使用这两个方法来做一些参数的初始化和销毁操
 * 作。比如接口暴漏、数据库数据读取、配置文件加载等等。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-17 22:38
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
