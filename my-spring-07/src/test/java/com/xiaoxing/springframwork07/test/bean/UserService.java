package com.xiaoxing.springframwork07.test.bean;

import com.xiaoxing.springframwork07.beans.factory.DisposableBean;
import com.xiaoxing.springframwork07.beans.factory.InitializingBean;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-06 23:18
 */
public class UserService implements InitializingBean, DisposableBean {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：com.xiaoxing.springframwork07.test.bean.UserService.destroy");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：com.xiaoxing.springframwork07.test.bean.UserService.afterPropertiesSet");
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
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
}
