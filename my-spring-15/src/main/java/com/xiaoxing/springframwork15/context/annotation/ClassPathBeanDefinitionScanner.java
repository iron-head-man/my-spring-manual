package com.xiaoxing.springframwork15.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.xiaoxing.springframwork15.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import com.xiaoxing.springframwork15.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork15.beans.factory.support.BeanDefinitionRegistry;
import com.xiaoxing.springframwork15.stereotype.Component;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-27 0:13
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        // 注册处理注解的 BeanPostProcessor（@Autowired、@Value）---》名字写死？
        registry.registerBeanDefinition(
                        "com.xiaoxing.springframwork15.context.annotation.internalAutowiredAnnotationProcessor",
                        new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));

    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope)
            return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }

}
