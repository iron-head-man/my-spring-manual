package java.com.xiaoxing.springframwork06.beans.factory.config;


import java.com.xiaoxing.springframwork06.beans.BeanException;
import java.com.xiaoxing.springframwork06.beans.factory.BeanFactory;

/**
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException;
}
