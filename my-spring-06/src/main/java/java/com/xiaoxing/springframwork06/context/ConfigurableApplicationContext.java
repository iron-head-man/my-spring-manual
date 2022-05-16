package java.com.xiaoxing.springframwork06.context;

import java.com.xiaoxing.springframwork06.beans.BeanException;

/**
 * <p>
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the ApplicationContext
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-11 22:14
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     *
     * @throws BeanException
     */
    void refresh() throws BeanException;
}
