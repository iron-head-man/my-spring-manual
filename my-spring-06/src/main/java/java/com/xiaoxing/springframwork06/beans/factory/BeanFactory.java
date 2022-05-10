package java.com.xiaoxing.springframwork06.beans.factory;

import java.com.xiaoxing.springframwork06.beans.BeanException;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 22:29
 */
public interface BeanFactory {


    Object getBean(String name) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

}
