import com.xiaoxing.springframwork07.context.support.ClassPathXmlApplicationContext;
import com.xiaoxing.springframwork07.test.bean.UserService;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-06 23:20
 */
public class ApiTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }

}
