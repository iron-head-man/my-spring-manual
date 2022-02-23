package com.xiaoxing.springframwork04.beans.factory.support;

import com.xiaoxing.springframwork04.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork04.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 22:32
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map map = new HashMap<String, Object>();

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }

    public void addSingleton(String beanName,Object object){
        map.put(beanName,object);
    }
}
