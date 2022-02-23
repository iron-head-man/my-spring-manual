package com.xiaoxing.springframwork04.beans;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-23 21:45
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
