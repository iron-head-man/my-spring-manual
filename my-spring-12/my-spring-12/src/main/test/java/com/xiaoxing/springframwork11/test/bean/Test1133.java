package com.xiaoxing.springframwork12.test.bean;

import com.xiaoxing.springframwork12.aop.aspectj.AspectJExpressionPointcut;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-13 10:36
 */
public class Test1133 {

    @Test
    public void test_1123(){

            IUserService userService = (IUserService) Proxy.newProxyInstance(
                    Thread.currentThread().getContextClassLoader(), new Class[]{IUserService.class}, (proxy, method, args) -> "你被代理了！");
            String result = userService.queryUserInfo();
            System.out.println("测试结果：" + result);

    }

    @Test
    public void test_proxy_method() {
//        // 目标对象(可以替换成任何的目标对象)
//        Object targetObj = new com.xiaoxing.springframwork12.test.bean.UserService();
//        // AOP 代理
//        com.xiaoxing.springframwork12.test.bean.IUserService proxy = (com.xiaoxing.springframwork12.test.bean.IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
//            // 方法匹配器
//            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.com.xiaoxing.springframwork12.test.bean.IUserService.*(..))");
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                if (methodMatcher.matches(method, targetObj.getClass())) {
//                    // 方法拦截器
//                    MethodInterceptor methodInterceptor = invocation -> {
//                        long start = System.currentTimeMillis();
//                        try {
//                            return invocation.proceed();
//                        } finally {
//                            System.out.println("监控 - Begin By AOP");
//                            System.out.println("方法名称：" + invocation.getMethod().getName());
//                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
//                            System.out.println("监控 - End\r\n");
//                        }
//                    };
//                    // 反射调用
//                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
//                }
//                return method.invoke(targetObj, args);
//            }
//        });
//        String result = proxy.queryUserInfo();
//        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_123() throws NoSuchMethodException {
        //找到方法切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.xiaoxing.springframwork12.test.bean.UserService.*(..))");

        Class<UserService> userServiceClass = UserService.class;
        Method queryUserInfo = userServiceClass.getMethod("queryUserInfo");

        System.out.println(pointcut.matches(userServiceClass));
        System.out.println(pointcut.matches(queryUserInfo,userServiceClass));
    }

}
