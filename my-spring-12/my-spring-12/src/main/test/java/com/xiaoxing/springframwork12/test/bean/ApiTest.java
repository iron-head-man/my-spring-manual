package com.xiaoxing.springframwork12.test.bean;

import com.xiaoxing.springframwork12.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-25 11:15
 */
public class ApiTest {


    @Test
    public void test_aop() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.queryUserInfo());

    }
}
