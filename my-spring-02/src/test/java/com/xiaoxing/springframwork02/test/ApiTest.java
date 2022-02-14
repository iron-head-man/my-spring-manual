package com.xiaoxing.springframwork02.test;

import com.xiaoxing.springframwork02.factory.BeanDefinition;
import com.xiaoxing.springframwork02.factory.support.DefaultListableBeanFactory;
import com.xiaoxing.springframwork02.test.bean.UserService;
import org.junit.Test;

/**
 * @author xxhstart
 * @create 2022-02-14 23:01
 * @description:
 */
public class ApiTest {


    @Test
    public void test11(){

        //1.初始化bean工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //2.定义beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        //3.注册bean
        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);
        //4.获取bean调用方法
        UserService userService = (UserService)(defaultListableBeanFactory.getBean("userService"));

        userService.queryInfo();

    }

}
