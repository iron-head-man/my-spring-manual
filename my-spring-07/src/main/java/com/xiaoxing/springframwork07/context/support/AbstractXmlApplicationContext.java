package com.xiaoxing.springframwork07.context.support;

import com.xiaoxing.springframwork07.beans.factory.support.DefaultListableBeanFactory;
import com.xiaoxing.springframwork07.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Convenient base class for {@link com.xiaoxing.springframwork07.context.ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions
 * understood by an {@link com.xiaoxing.springframwork07.beans.factory.xml.XmlBeanDefinitionReader}.
 *
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
