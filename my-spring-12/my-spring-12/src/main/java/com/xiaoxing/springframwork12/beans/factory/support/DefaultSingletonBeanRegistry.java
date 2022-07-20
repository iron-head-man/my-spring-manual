package com.xiaoxing.springframwork12.beans.factory.support;

import com.xiaoxing.springframwork12.beans.BeansException;
import com.xiaoxing.springframwork12.beans.factory.DisposableBean;
import com.xiaoxing.springframwork12.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    protected static final Object NULL_OBJECT = new Object();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }


    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons(){
        Set<String> beanNames = disposableBeans.keySet();
        //实现销毁接口的beanName，统一销毁
        Object[]  disposableBeanNames = beanNames.toArray();

        for (int i = disposableBeanNames.length -1 ;i>=0;i--){
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean remove = disposableBeans.remove(disposableBeanName);
            try {
                remove.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' threw an exception", e);
            }
        }
    }

}
