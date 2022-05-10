package java.com.xiaoxing.springframwork06.beans.factory.support;

import java.com.xiaoxing.springframwork06.core.io.Resource;
import java.com.xiaoxing.springframwork06.core.io.ResourceLoader;

/**
 * <p>
 * 这是一个 Simple interface for bean definition readers. 其实里面无非定义了几个方
 * 法，包括： getRegistry()、 getResourceLoader()，以及三个加载 Bean 定义的方法。
 *
 * 这里需要注意 getRegistry()、 getResourceLoader()，都是用于提供给后面三个方法
 * 的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口
 * 实现方法。
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 22:42
 */
public interface BeanDefinitionReader {


    /**
     * <p>
     * 注册动作类--->方便注册bean定义
     * </p>
     * @return java.com.xiaoxing.springframwork06.beans.factory.support.BeanDefinitionRegistry
     * @author heng.xing@hand-china.com 2022/5/9 16:45
     */
    BeanDefinitionRegistry getRegistry();

    /***
     * <p>
     * 获取资源加载器--->方便注册bean定义
     * </p>
     * @return: java.com.xiaoxing.springframwork06.core.io.ResourceLoader
     * @author heng.xing@hand-china.com 2022/3/2 22:44
     */
    ResourceLoader getResourceLoader();
    /**
     * <p>
     * 从单个资源加载bean定义
     * </p>
     * @param resource:  
     * @return void
     * @author heng.xing@hand-china.com 2022/5/9 16:34
     */
    void loadBeanDefinitions(Resource resource);
    /**
     * <p>
     * 多个资源记载bean定义
     * </p>
     * @param resources:
     * @return void
     * @author heng.xing@hand-china.com 2022/5/9 16:35
     */
    void loadBeanDefinitions(Resource... resources);
    /**
     * <p>
     * 从location加载bean定义
     * </p>
     * @param location:
     * @return void
     * @author heng.xing@hand-china.com 2022/5/9 16:35
     */
    void loadBeanDefinitions(String location);

}
