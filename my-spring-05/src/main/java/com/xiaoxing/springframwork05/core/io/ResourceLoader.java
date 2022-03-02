package com.xiaoxing.springframwork05.core.io;

/**
 * <p>
 * 资源加载器
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 21:58
 */
public interface ResourceLoader {


    String CLASSPATH_URL_PREFIX = "classpath:";

    /***
     * <p>
     * 获取资源
     * </p>
     * @param location:
     * @return: com.xiaoxing.springframwork05.core.io.Resource
     * @author heng.xing@hand-china.com 2022/3/2 21:59
     */
    Resource getResource(String location);
}
