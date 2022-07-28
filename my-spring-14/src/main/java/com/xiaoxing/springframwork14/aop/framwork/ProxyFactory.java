package com.xiaoxing.springframwork14.aop.framwork;

import com.xiaoxing.springframwork14.aop.AdvisedSupport;

/**
 * <p>
 * 代理工厂,其实这个代理工厂主要解决的是关于 JDK 和 Cglib 两种代理的选择问题，有了代
 * 理工厂就可以按照不同的创建需求进行控制。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-20 23:13
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);

    }

    public static void main(String[] args) {

        System.out.println(String.format("收款申请单[%s]系统自动审批","docNumber"));
    }
}
