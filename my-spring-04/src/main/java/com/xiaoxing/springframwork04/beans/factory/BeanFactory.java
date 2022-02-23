package com.xiaoxing.springframwork04.beans.factory;

import com.xiaoxing.springframwork04.beans.BeanException;

/**
 * <p>
 * 顶级接口
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 21:24
 */
public interface BeanFactory {

    /***
     * <p>
     * 获取无参数bean
     * </p>
     * @param beanName:
     * @return: java.lang.Object
     * @author heng.xing@hand-china.com 2022/2/23 21:25
     */
    Object getBean(String beanName)throws BeanException;
    /***
     * <p>
     * 获取有参数bean
     * </p>
     * @param beanName:
     * @param args:
     * @return: java.lang.Object
     * @author heng.xing@hand-china.com 2022/2/23 21:27
     */
    Object getBean(String beanName,Object... args)throws BeanException;
}
