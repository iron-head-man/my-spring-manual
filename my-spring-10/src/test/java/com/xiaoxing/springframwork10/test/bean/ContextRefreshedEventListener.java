package com.xiaoxing.springframwork10.test.bean;

import com.xiaoxing.springframwork10.context.ApplicationListener;
import com.xiaoxing.springframwork10.context.event.ContextRefreshedEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 17:22
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件："+this.getClass().getName());
    }
}
