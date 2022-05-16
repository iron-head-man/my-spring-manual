package java.com.xiaoxing.springframwork06.beans.factory.config;

import java.com.xiaoxing.springframwork06.beans.BeanException;
import java.com.xiaoxing.springframwork06.beans.factory.ConfigurableListableBeanFactory;

/**
 * <p>
 *  允许自定义修改 BeanDefinition 属性信息
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-11 0:50
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *  中文名：后处理bean工厂
     * @param beanFactory
     * @throws BeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException;

}
