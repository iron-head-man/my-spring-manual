package com.xiaoxing.springframwork11.context;

import com.xiaoxing.springframwork11.beans.BeansException;
import com.xiaoxing.springframwork11.beans.factory.Aware;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-07 21:34
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
