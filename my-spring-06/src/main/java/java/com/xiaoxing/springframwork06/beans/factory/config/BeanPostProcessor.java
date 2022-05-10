package java.com.xiaoxing.springframwork06.beans.factory.config;

import java.com.xiaoxing.springframwork06.beans.BeanException;

/**
 * <p>
 *  用于修改新实例化 Bean 对象的扩展点
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-11 0:52
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException;

}
