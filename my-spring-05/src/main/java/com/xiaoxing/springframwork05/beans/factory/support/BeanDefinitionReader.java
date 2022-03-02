package com.xiaoxing.springframwork05.beans.factory.support;

import com.xiaoxing.springframwork05.core.io.Resource;
import com.xiaoxing.springframwork05.core.io.ResourceLoader;

/**
 * <p>
 * bean定义的读取接口,三个，前两个方法是为后三个提供的工具，放到后面的抽象类中实现，避免污染具体接口的实现方法
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 22:42
 */
public interface BeanDefinitionReader {



    BeanDefinitionRegistry getRegistry();

    /***
     * <p>
     * 获取资源加载器
     * </p>
     * @return: com.xiaoxing.springframwork05.core.io.ResourceLoader
     * @author heng.xing@hand-china.com 2022/3/2 22:44
     */
    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource);
    void loadBeanDefinitions(Resource... resources);
    void loadBeanDefinitions(String location);

}
