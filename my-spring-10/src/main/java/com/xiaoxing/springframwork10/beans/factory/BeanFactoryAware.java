package com.xiaoxing.springframwork10.beans.factory;

import com.xiaoxing.springframwork10.beans.BeansException;

/**
 * <p>
 *  Interface to be implemented by beans that wish to be aware of their owning {@link BeanFactory}.
 *  实现此接口，既能感知到所属的 BeanFactory
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-07 21:10
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
