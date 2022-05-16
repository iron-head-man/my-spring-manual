package java.com.xiaoxing.springframwork06.beans.factory;


import java.com.xiaoxing.springframwork06.beans.BeanException;
import java.com.xiaoxing.springframwork06.beans.factory.config.AutowireCapableBeanFactory;
import java.com.xiaoxing.springframwork06.beans.factory.config.BeanDefinition;
import java.com.xiaoxing.springframwork06.beans.factory.config.BeanPostProcessor;
import java.com.xiaoxing.springframwork06.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    /***
     * <p>
     *
     * </p>
      
     * @return void
     * @author heng.xing@hand-china.com 2022/5/11 22:41
     */
    void preInstantiateSingletons() throws BeanException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);


}
