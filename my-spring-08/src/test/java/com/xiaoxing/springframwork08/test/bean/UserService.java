package com.xiaoxing.springframwork08.test.bean;

import com.xiaoxing.springframwork08.beans.BeansException;
import com.xiaoxing.springframwork08.beans.factory.BeanClassLoaderAware;
import com.xiaoxing.springframwork08.beans.factory.BeanFactory;
import com.xiaoxing.springframwork08.beans.factory.BeanFactoryAware;
import com.xiaoxing.springframwork08.beans.factory.BeanNameAware;
import com.xiaoxing.springframwork08.context.ApplicationContext;
import com.xiaoxing.springframwork08.context.ApplicationContextAware;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-07 22:31
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private String uId;
    private String company;
    private String location;
    private UserDao userDao;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("classLoader  is" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory is:"+beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is:"+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

//    public UserService(String uId, String company, String location, UserDao userDao) {
//        this.uId = uId;
//        this.company = company;
//        this.location = location;
//        this.userDao = userDao;
//    }
}
