package com.xiaoxing.springframwork12.context;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 15:13
 */
public interface ApplicationEventPublisher {


    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     *
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
