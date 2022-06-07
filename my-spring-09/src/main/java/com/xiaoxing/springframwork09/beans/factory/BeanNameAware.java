package com.xiaoxing.springframwork09.beans.factory;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-07 21:32
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String name);
}
