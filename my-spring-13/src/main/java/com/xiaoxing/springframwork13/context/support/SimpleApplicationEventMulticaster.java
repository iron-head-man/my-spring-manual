package com.xiaoxing.springframwork13.context.support;

import com.xiaoxing.springframwork13.beans.factory.BeanFactory;
import com.xiaoxing.springframwork13.context.ApplicationEvent;
import com.xiaoxing.springframwork13.context.ApplicationListener;
import com.xiaoxing.springframwork13.context.event.AbstractApplicationEventMulticaster;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 15:35
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }
}
