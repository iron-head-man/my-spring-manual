package java.com.xiaoxing.springframwork06.beans.factory.config;


import java.com.xiaoxing.springframwork06.beans.factory.BeanFactory;

/**
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
}
