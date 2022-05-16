package java.com.xiaoxing.springframwork06.context.support;

import java.com.xiaoxing.springframwork06.beans.factory.support.DefaultListableBeanFactory;
import java.com.xiaoxing.springframwork06.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * <p>
 *  1、ClassPathXmlApplicationContext，是具体对外给用户提供的应用上下文方法。
 *  2、在继承了 AbstractXmlApplicationContext 以及层层抽象类的功能分离实现后，
 *  在此类 ClassPathXmlApplicationContext 的实现中就简单多了，主要是对继承抽象类中方法的调用和提供了配置文件地址信息。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-11 22:56
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        //既是 注册的类，又是资源加载类
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
