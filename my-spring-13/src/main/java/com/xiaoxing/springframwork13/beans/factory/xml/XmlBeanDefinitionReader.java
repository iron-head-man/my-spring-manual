package com.xiaoxing.springframwork13.beans.factory.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.xiaoxing.springframwork13.context.annotation.ClassPathBeanDefinitionScanner;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xiaoxing.springframwork13.beans.BeansException;
import com.xiaoxing.springframwork13.beans.PropertyValue;
import com.xiaoxing.springframwork13.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork13.beans.factory.config.BeanReference;
import com.xiaoxing.springframwork13.beans.factory.support.AbstractBeanDefinitionReader;
import com.xiaoxing.springframwork13.beans.factory.support.BeanDefinitionRegistry;
import com.xiaoxing.springframwork13.core.io.Resource;
import com.xiaoxing.springframwork13.core.io.ResourceLoader;

import cn.hutool.core.util.StrUtil;

/**
 * Bean definition reader for XML bean definitions.
 * <p>
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！ 公众号：bugstack虫洞栈 Create by 小傅哥(fustack)
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, DocumentException {
        // Document doc = XmlUtil.readXML(inputStream);
        // Element root = doc.getDocumentElement();
        // NodeList childNodes = root.getChildNodes();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();

        Element componentScan = root.element("component-scan");
        if (null != componentScan) {
            String scanPath = componentScan.attributeValue("base-package");
            if (StrUtil.isEmpty(scanPath)) {
                throw new BeansException("The value of base-package attribute can not be empty or null");
            }
            //从xml中读取扫描包的位置---如何从注解读取扫描包的位置呢？
            scanPackage(scanPath);
        }

        List<Element> beanList = root.elements("bean");
        for (Element bean : beanList) {
            // // 判断元素
            // if (!(childNodes.item(i) instanceof Element)) continue;
            // // 判断对象
            // if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // 解析标签
            // Element bean = (Element) childNodes.item(i);
            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            String initMethod = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String beanScope = bean.attributeValue("scope");

            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);
            // 09小节新增：在解析 XML 处理类 XmlBeanDefinitionReader 中，新增加了关于 Bean 对象配置
            // 中 scope 的解析，并把这个属性信息填充到 Bean 定义中。
            // beanDefinition.setScope(beanScope)
            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }

            // 读取属性并填充
            List<Element> propertyList = bean.elements("property");
            for (Element property : propertyList) {

                // if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                // if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                // // 解析标签：property
                // Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private void scanPackage(String scanPath) {
        String[] basePackages = StrUtil.splitToArray(scanPath, ',');
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
        scanner.doScan(basePackages);
    }

}
