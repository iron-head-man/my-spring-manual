import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-21 20:24
 */
public class ThreadLocalTest {



    @Test
    public void test11() {

        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("wade");
        objectThreadLocal.set("kobe");
        objectThreadLocal.get();

        String s = "=12345=";
        Long.parseLong(s);

    }

    @Test
    public void test1111() {

        ExecutorService taskExecutor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(10));

        String name = "xiaoming";
        Integer age = 13;

        MyExcutor myExcutor = new MyExcutor(name, age);

        taskExecutor.execute(myExcutor);


    }
}
