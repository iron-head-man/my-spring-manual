package java.com.xiaoxing.springframwork06.context.support;

import java.com.xiaoxing.springframwork06.beans.BeanException;
import java.com.xiaoxing.springframwork06.beans.factory.ConfigurableListableBeanFactory;
import java.com.xiaoxing.springframwork06.beans.factory.support.DefaultListableBeanFactory;


/**
 * <p>
 *  实现了刷新bean工厂的方法
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-11 22:41
 */
public abstract class AbstractRefreshableApplicationContext extends  AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeanException {
        //创建一个beanFactory
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 传入新建的bean工厂，定义了一个向其中加载bean定义的动作，具体实现没写
        loadBeanDefinitions(beanFactory);
        //将加载完bean定义的的beanFactory赋予成员变量
        this.beanFactory = beanFactory;
    }

    //直接new了一个对应类型的beanFactory返回
    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    //传入一个bean工厂，然后去加载bean定义,这个方法让继承他的类去实现
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
