package com.xiaoxing.springframwork08.beans.factory;

import com.xiaoxing.springframwork08.beans.factory.Aware;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-07 21:32
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
