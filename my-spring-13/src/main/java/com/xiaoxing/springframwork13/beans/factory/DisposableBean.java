package com.xiaoxing.springframwork13.beans.factory;

/**
 * <p>
 *  InitializingBean、DisposableBean，两个接口方法还是比较常用的，在一些需要结
 * 合 Spring 实现的组件中，经常会使用这两个方法来做一些参数的初始化和销毁操
 * 作。比如接口暴漏、数据库数据读取、配置文件加载等等。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-17 22:39
 */
public interface DisposableBean {
    /**
     * <p>
     * 销毁bean
     * </p>
     * @return void
     * @author heng.xing@hand-china.com 2022/5/17 22:39
     */
    void destroy() throws Exception;
}
