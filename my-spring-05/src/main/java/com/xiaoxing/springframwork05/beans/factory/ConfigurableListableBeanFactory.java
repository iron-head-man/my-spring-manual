package com.xiaoxing.springframwork05.beans.factory;


import com.xiaoxing.springframwork05.beans.BeanException;
import com.xiaoxing.springframwork05.beans.factory.config.AutowireCapableBeanFactory;
import com.xiaoxing.springframwork05.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork05.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

}
