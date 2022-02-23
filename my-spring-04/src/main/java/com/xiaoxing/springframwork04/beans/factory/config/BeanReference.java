package com.xiaoxing.springframwork04.beans.factory.config;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 22:06
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
