package com.xiaoxing.springframwork11.test.bean;

import com.xiaoxing.springframwork11.test.bean.IUserDao;
import com.xiaoxing.springframwork11.test.bean.IUserService;

import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-08 22:40
 */
public class UserService implements IUserService {

//    private String uId;
//    private String company;
//    private String location;
//    private IUserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }


}
