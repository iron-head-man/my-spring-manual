package com.xiaoxing.springframwork14.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.xiaoxing.springframwork14.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork14.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-07-27 0:10
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {

        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
