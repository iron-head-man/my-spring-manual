import com.xiaoxing.springframwork03.beans.factory.config.BeanDefinition;
import com.xiaoxing.springframwork03.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-02-22 22:03
 */
public class ApiTest {

    @Test
    public void test112(){
        //1.准备好bean定义
        BeanDefinition beanDefinition = new BeanDefinition(Student.class);
        //2.准备Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //3.注册bean
        beanFactory.registerBeanDefinition(beanDefinition.getClazz().getName(),beanDefinition);
        //4.获取bean
        Student bean = (Student)beanFactory.getBean(beanDefinition.getClazz().getName(),18);
        System.out.println(bean);
    }


    //constructor构造bean
    @Test
    public void test119() throws Exception {

        Constructor<Student> constructor = Student.class.getDeclaredConstructor(Integer.class);

        Student xiaoming = constructor.newInstance(11);

        System.out.println(xiaoming);
    }
}
