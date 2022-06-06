package com.xiaoxing.springframwork07.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-06 23:14
 */
public class UserDao {

    private static Map<String,String> hashMap = new HashMap<>();



    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
