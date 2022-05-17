package common;


import java.com.xiaoxing.springframwork06.beans.BeanException;
import java.com.xiaoxing.springframwork06.beans.PropertyValue;
import java.com.xiaoxing.springframwork06.beans.PropertyValues;
import java.com.xiaoxing.springframwork06.beans.factory.ConfigurableListableBeanFactory;
import java.com.xiaoxing.springframwork06.beans.factory.config.BeanDefinition;
import java.com.xiaoxing.springframwork06.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
