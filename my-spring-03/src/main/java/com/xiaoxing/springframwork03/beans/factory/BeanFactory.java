package com.xiaoxing.springframwork03.beans.factory;

import com.xiaoxing.springframwork03.beans.BeanException;

/**
 * @author xxhstart
 * @create 2022-02-16 10:26
 * @description: 工厂顶级接口
 */
public interface BeanFactory {

    /**
     * 返回无参数实例bean
     * @return
     */
    public Object getBean(String name) throws BeanException;

    /**
     * 返回带参数实例bean,get的时候注入创建bean
     * @param name
     * @param args
     * @return
     * @throws BeanException
     */
    public Object getBean(String name,Object... args) throws BeanException;

}
