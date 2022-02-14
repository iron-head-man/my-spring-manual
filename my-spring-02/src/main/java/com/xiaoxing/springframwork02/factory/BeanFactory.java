package com.xiaoxing.springframwork02.factory;

import com.xiaoxing.springframwork02.BeansException;

/**
 * @author xxhstart
 * @create 2022-02-10 18:24
 * @description: 顶级接口，规定了实现该接口要做的事情
 */
public interface BeanFactory {

    /**
     *
     * @param name
     * @return bean对象
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

}
