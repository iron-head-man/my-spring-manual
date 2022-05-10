package java.com.xiaoxing.springframwork06.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-09 15:53
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    //添加一个新属性
    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }
    //返回一个新数组
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }
    //返回指定属性名的属性
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }


}
