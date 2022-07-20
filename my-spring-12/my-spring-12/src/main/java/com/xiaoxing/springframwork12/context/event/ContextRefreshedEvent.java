package com.xiaoxing.springframwork12.context.event;

import com.xiaoxing.springframwork12.context.ApplicationEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 11:07
 */
public class ContextRefreshedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
