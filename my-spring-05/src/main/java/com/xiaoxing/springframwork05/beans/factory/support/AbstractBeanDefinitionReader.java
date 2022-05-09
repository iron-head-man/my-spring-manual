package com.xiaoxing.springframwork05.beans.factory.support;

import com.xiaoxing.springframwork05.core.io.DefaultResourceLoader;
import com.xiaoxing.springframwork05.core.io.ResourceLoader;

/**
 * <p>
 * 主要实现了getRegistry()\getResourceLoader()两个方法
 *
 * 抽象类把 BeanDefinitionReader 接口的前两个方法全部实现完了，并提供了构造 函数，让外部的调用使用方，把 Bean 定义注入类，传递进来。
 *
 * 这样在接口 BeanDefinitionReader 的具体实现类中，就可以把解析后的 XML 文 件中的 Bean 信息，注册到 Spring 容器去了。 以前我们是通过单元测试使用，调 用
 * BeanDefinitionRegistry 完成 Bean 的注册，现在可以放到 XMl 中操作了
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 22:52
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {


    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = registry;
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
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
