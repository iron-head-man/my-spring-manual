package java.com.xiaoxing.springframwork06.context.support;

import java.com.xiaoxing.springframwork06.beans.BeanException;
import java.com.xiaoxing.springframwork06.beans.factory.ConfigurableListableBeanFactory;
import java.com.xiaoxing.springframwork06.beans.factory.config.BeanFactoryPostProcessor;
import java.com.xiaoxing.springframwork06.beans.factory.config.BeanPostProcessor;
import java.com.xiaoxing.springframwork06.context.ConfigurableApplicationContext;
import java.com.xiaoxing.springframwork06.core.io.DefaultResourceLoader;
import java.util.Map;

/**
 * <p>
 *  继承resourceLoader方便后面从配置文件中读取bean定义
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-11 22:17
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader
                implements ConfigurableApplicationContext {


    //todo 问题：如何定义刷新一个容器？
    @Override
    public void refresh() throws BeanException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition，没定义具体如何创建bean工厂和加载bean定义
        refreshBeanFactory();

        // 2. 获取 BeanFactory，没具体定义如何获取
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the
        // context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    // 1. 创建 BeanFactory，并加载 BeanDefinition
    protected abstract void refreshBeanFactory() throws BeanException;


    // // 2. 获取 BeanFactory
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the
    // context.)
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap =
                        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            //先执行所有的 对bean定义，或实例化之前的操作
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            //将所有 BeanPostProcessor提前add到beanFactory中
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeanException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        return getBeanFactory().getBean(name, requiredType);
    }


}
