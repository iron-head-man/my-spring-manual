package com.xiaoxing.springframwork10.test.bean;

import com.xiaoxing.springframwork10.context.event.ApplicationContextEvent;

/**
 * <p>
 *  创建一个自定义事件，在事件类的构造函数中可以添加自己的想要的入参信息。这
 * 个事件类最终会被完成的拿到监听里，所以你添加的属性都会被获得到。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 16:36
 */
public class CustomEvent extends ApplicationContextEvent {


    private Long id;

    private String message;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source,Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
