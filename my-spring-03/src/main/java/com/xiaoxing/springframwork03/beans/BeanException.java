package com.xiaoxing.springframwork03.beans;

/**
 * @author xxhstart
 * @create 2022-02-16 10:21
 * @description:
 */
public class BeanException extends RuntimeException{

    public BeanException(String msg,Throwable throwable){
        super( msg,throwable);
    }

    public BeanException(String msg){

        super(msg);
    }


}
