package com.xiaoxing.springframwork09.test.bean;

import com.xiaoxing.springframwork09.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-08 23:10
 */
public class ApiTest {
    @Test
    public void test_prototype() {
        //读取xml文件，初始化容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //注册关闭钩子
        applicationContext.registerShutdownHook();

        //获取类实例
        UserService userService = applicationContext.getBean("userService", UserService.class);
        UserService userService1 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService);
        System.out.println(userService1);

        // 4. 打印十六进制哈希
        System.out.println(userService1 + " 十六进制哈希：" + Integer.toHexString(userService1.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService1).toPrintable());

    }

    @Test
    public void test_factory_bean(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
