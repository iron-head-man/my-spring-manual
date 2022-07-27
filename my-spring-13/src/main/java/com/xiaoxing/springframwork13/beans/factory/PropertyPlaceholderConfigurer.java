package com.xiaoxing.springframwork13.beans.factory;

import com.xiaoxing.springframwork13.beans.BeansException;
import com.xiaoxing.springframwork13.beans.PropertyValue;
import com.xiaoxing.springframwork13.beans.PropertyValues;
import com.xiaoxing.springframwork13.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork13.beans.factory.config.BeanFactoryPostProcessor;
import com.xiaoxing.springframwork13.core.io.DefaultResourceLoader;
import com.xiaoxing.springframwork13.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * <p>
 * 处理配置文件中的属性
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-26 22:31
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    /**
     * Default placeholder prefix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    /**
     * Default placeholder suffix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        try {
            // 加载属性文件
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {

                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();

                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String))
                        continue;
                    String strVal = (String) value;

                    StringBuffer buffer = new StringBuffer(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int endIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    //存在
                    if (startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
                        String propKey = strVal.substring(startIdx + 2, endIdx);
                        String propVal = properties.getProperty(propKey);
                        buffer.replace(startIdx, endIdx + 1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buffer.toString()));

                    }
                }

            }
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
