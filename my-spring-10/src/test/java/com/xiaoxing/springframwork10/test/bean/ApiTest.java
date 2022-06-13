package com.xiaoxing.springframwork10.test.bean;

import com.xiaoxing.springframwork10.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-10 17:24
 */
public class ApiTest {

    @Test
    public void test_11(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext,101010101L,"小邢成功了"));

        applicationContext.registerShutdownHook();
    }
}
