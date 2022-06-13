package com.xiaoxing.springframwork11.context;

import com.xiaoxing.springframwork11.beans.factory.HierarchicalBeanFactory;
import com.xiaoxing.springframwork11.beans.factory.ListableBeanFactory;
import com.xiaoxing.springframwork11.core.io.ResourceLoader;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 *
 * 应用上下文
 *
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher{
}
