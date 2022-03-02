package com.xiaoxing.springframwork05.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 21:47
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }


}
