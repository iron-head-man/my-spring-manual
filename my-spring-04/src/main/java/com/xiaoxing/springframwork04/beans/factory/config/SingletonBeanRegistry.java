package com.xiaoxing.springframwork04.beans.factory.config;

/**
 * <p>
 * 单例获取接口
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 22:13
 */
public interface SingletonBeanRegistry {
    /***
     * <p>
     * 根据bean名字获取单例baen
     * </p>
     * @param beanName:
     * @return: java.lang.Object
     * @author heng.xing@hand-china.com 2022/2/23 22:14
     */
    Object getSingleton(String beanName);
}
