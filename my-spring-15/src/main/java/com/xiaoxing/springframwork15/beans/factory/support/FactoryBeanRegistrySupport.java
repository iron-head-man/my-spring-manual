package com.xiaoxing.springframwork15.beans.factory.support;

import com.xiaoxing.springframwork15.beans.BeansException;
import com.xiaoxing.springframwork15.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * FactoryBeanRegistrySupport 类主要处理的就是关于 FactoryBean 此类对象的注册
 * 操作，之所以放到这样一个单独的类里，就是希望做到不同领域模块下只负责各自需要完成的功能，避免因为扩展导致类膨胀到难以维护。
 *  同样这里也定义了缓存操作 factoryBeanObjectCache，用于存放单例类型的对象，
 * 避免重复创建。在日常使用用，基本也都是创建的单例对象
 *  doGetObjectFromFactoryBean 是具体的获取 FactoryBean#getObject() 方法，因
 * 为既有缓存的处理也有对象的获取，所以额外提供了 getObjectFromFactoryBean
 * 进行逻辑包装，这部分的操作方式是不和你日常做的业务逻辑开发非常相似。从
 * Redis 取数据，如果为空就从数据库获取并写入 Redis
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-08 21:28
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                //没有就创建一个
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            //直接创建，不管有没有
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
