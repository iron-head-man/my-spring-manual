package com.xiaoxing.springframwork14.util;

import com.xiaoxing.springframwork14.context.ApplicationListener;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    public static boolean isCglibProxyClass(Class<? extends ApplicationListener> aClass) {
        return (null != aClass && isCglibProxyClassName(aClass.getName()));
    }

    private static boolean isCglibProxyClassName(String name) {
        return (name != null && name.contains("$$"));
    }
}
