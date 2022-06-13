package com.xiaoxing.springframwork10.test.bean;

import com.xiaoxing.springframwork10.context.ApplicationListener;
import com.xiaoxing.springframwork10.context.event.ContextClosedEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 17:20
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件："+this.getClass().getName());
    }
}
