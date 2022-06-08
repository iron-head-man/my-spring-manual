package com.xiaoxing.springframwork09.beans.factory;

/**
 * <p>
 *  FactoryBean 中需要提供 3 个方法，获取对象、对象类型，以及是否是单例对象，
 * 如果是单例对象依然会被放到内存中。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-08 21:26
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
