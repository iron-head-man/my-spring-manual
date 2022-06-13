package com.xiaoxing.springframwork10.test.bean;

import com.xiaoxing.springframwork10.context.ApplicationListener;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 16:38
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {

        System.out.println("收到：【"+event.getSource()+"】消息；时间:"+new Date());

        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }


}
