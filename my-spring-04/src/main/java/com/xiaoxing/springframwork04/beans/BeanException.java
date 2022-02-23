package com.xiaoxing.springframwork04.beans;

/**
 * <p>
 * 异常类
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-22 22:41
 */
public class BeanException extends RuntimeException{

    BeanException(String meg){};

    BeanException(String msg ,Throwable throwable){};
}
