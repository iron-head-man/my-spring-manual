package com.xiaoxing.springframwork02.test;


import com.xiaoxing.springframwork02.test.bean.DTO;
import com.xiaoxing.springframwork02.test.bean.UserDao;
import com.xiaoxing.springframwork02.test.bean.UserService;
import com.xiaoxing.springframwork04.beans.PropertyValue;
import com.xiaoxing.springframwork04.beans.PropertyValues;
import com.xiaoxing.springframwork04.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork04.beans.factory.config.BeanReference;
import com.xiaoxing.springframwork04.beans.factory.support.DefaultListableBeanFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-28 22:50
 */
public class ApiTest {

    @Test
    public void test111(){

        //1.初始化bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册bean
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //4.userService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();


    }

    @Before
    public void init(){

        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

//        BaseExecutor

//        SqlSessionFactory factory = factoryBuilder.build();
//
//        CachingExecutor cachingExecutor =new CachingExecutor();
    }


    @Test
    public void mybatisTest(){

//        Configuration conf;
//        new BatchExecutor(conf,transac);

        long index = 1000;
        //1099511627776
        System.out.println(1<<index);
    }

    @Test
    public void mybatisTest11(){

        String json = "[{\"reversePlan\": \"3\"},{\"reversePlan\": \"4\"}]";

        List<DTO> dtos = JSONObject.parseArray(json, DTO.class);

        dtos.stream().forEach(s->{
            System.out.println("*********");
            System.out.println(s.getReversePlan());
        });


    }
}
