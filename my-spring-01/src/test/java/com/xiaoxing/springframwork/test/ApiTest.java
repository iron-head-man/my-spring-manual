package com.xiaoxing.springframwork.test;

import com.xiaoxing.springframwork.BeanDefine;
import com.xiaoxing.springframwork.BeanFactory;
import com.xiaoxing.springframwork.test.service.UserService;
import org.junit.Test;

/**
 * @author xxhstart
 * @create 2022-02-10 17:00
 * @description:
 */
public class ApiTest {

    @Test
    public void test01(){
        //bean工厂
        BeanFactory beanFactory = new BeanFactory();

        //注册bean
        BeanDefine beanDefine = new BeanDefine(new UserService());
        beanFactory.pushBean("userService",beanDefine);

        //拿到bean
        UserService userService =(UserService) (beanFactory.getBean("userService"));

        userService.logService();

    }
}
