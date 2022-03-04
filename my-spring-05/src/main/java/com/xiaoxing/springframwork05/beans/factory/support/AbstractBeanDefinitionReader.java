package com.xiaoxing.springframwork05.beans.factory.support;

import com.xiaoxing.springframwork05.core.io.DefaultResourceLoader;
import com.xiaoxing.springframwork05.core.io.ResourceLoader;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 22:52
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{


    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry,ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
        this.registry = registry;
    }
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
        this(registry, new DefaultResourceLoader());
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
