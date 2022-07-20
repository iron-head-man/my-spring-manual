package com.xiaoxing.springframwork12.context.event;

import com.xiaoxing.springframwork12.beans.BeansException;
import com.xiaoxing.springframwork12.beans.factory.BeanFactory;
import com.xiaoxing.springframwork12.beans.factory.BeanFactoryAware;
import com.xiaoxing.springframwork12.context.ApplicationEvent;
import com.xiaoxing.springframwork12.context.ApplicationListener;
import com.xiaoxing.springframwork12.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 11:21
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    //事件的事件监听器set
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public final void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {

        LinkedList<ApplicationListener> allListeners = new LinkedList<ApplicationListener>();

        applicationListeners.forEach(s -> {
            //如果监听器对事件感兴趣，则加入到集合中
            if (supportsEvent(s, event)) allListeners.add(s);
        });

        return allListeners;

    }

    private boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {

        // 按照 CglibSubclassingInstantiationStrategy、
        // SimpleInstantiationStrategy 不同的实例化类型，需要判断后获取目标 class
        Class<? extends ApplicationListener> aClass = applicationListener.getClass();
        Class<?> targetClass = ClassUtils.isCglibProxyClass(aClass) ? aClass.getSuperclass() : aClass;

        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];

        String typeName = actualTypeArgument.getTypeName();

        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + typeName);
        }
        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        // isAssignableFrom 是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是 Object。
        // 如果 A.isAssignableFrom(B)结果是 true，证明 B 可以转换成为 A,也就是 A 可以由 B 转换而来。简单来说A是不是B的父类或者父接口
        // tips:没有instance的时候判断父子类关系时使用
        return eventClassName.isAssignableFrom(event.getClass());
    }


}
