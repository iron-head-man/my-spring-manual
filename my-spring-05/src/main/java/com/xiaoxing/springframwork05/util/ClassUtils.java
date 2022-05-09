package com.xiaoxing.springframwork05.util;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 15:40
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {

        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            System.out.println("获取当前线程类加载器失败！");
        }
        if (cl==null){
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;

    }
}
