package java.com.xiaoxing.springframwork06.beans.factory.config;


import java.com.xiaoxing.springframwork06.beans.PropertyValues;

/**
 * <p>
 * 类定义类
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 21:29
 */
public class BeanDefinition {

    //类信息
    private Class clazz;
    //属性值集合
    private PropertyValues propertyValues;


    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class clazz, PropertyValues propertyValues) {
        this.clazz = clazz;
        this.propertyValues= propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
