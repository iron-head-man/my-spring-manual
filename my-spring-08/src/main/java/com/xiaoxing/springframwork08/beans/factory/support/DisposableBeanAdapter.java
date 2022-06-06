package com.xiaoxing.springframwork08.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.xiaoxing.springframwork07.beans.factory.DisposableBean;
import com.xiaoxing.springframwork07.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * <p>
 * Adapter that implements the {@link DisposableBean} and {@link Runnable} interfaces
 * * performing various destruction steps on a given bean instance:
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-17 23:30
 */
public class DisposableBeanAdapter implements DisposableBean {

    //销毁的bean、bean名字，销毁的方法
    private final Object bean;
    private String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }


    /**
     * <p>
     * 可能你会想这里怎么有一个适配器的类呢，因为销毁方法有两种甚至多种方式，目
     * 前有实现接口 DisposableBean、配置信息 destroy-method，两种方
     * 式。而这两种方式的销毁动作是由 AbstractApplicationContext 在注册虚拟机钩子
     * 后看，虚拟机关闭前执行的操作动作。
     *
     * 那么在销毁执行时不太希望还得关注都销毁那些类型的方法，它的使用上更希望是
     * 有一个统一的接口进行销毁，所以这里就新增了适配类，做统一处理。
     * </p>

     * @return void
     * @author heng.xing@hand-china.com 2022/6/6 22:18
     */
    @Override
    public void destroy() throws Exception {

        //销毁两种方式的判断
        //1.接口
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        //2.xml配置的方式
        if (StrUtil.isNotEmpty(this.destroyMethodName) && !(bean instanceof DisposableBean)
                && "destroy".equals(this.destroyMethodName)) {
            Method destroyMethod = bean.getClass().getEnclosingMethod();
            if (null == destroyMethod){
                throw new Exception("Couldn't find a destroy method named '" +
                        destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }

    }
}
