package com.xiaoxing.springframwork02;

/**
 * @author xxhstart
 * @create 2022-02-10 18:28
 * @description: bean获取错误抛出
 */
public class BeansException extends RuntimeException {

    //两种构造方法

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }

}
