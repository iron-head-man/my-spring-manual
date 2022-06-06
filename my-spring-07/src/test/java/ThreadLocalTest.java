import org.junit.Test;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.*;

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


    @Test
    public void test11112() {
//        RequestAttributes requestAttributes1 = new ServletRequestAttributes( "我是大哥");
//
//        RequestAttributes requestAttributes = RequestContextHolder.setRequestAttributes(s);
//
//
//
//        ThreadPoolExecutor bgtImportValidExecutor = new ThreadPoolExecutor(1, 1, 30,
//                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
//        CompletionService<Integer> bgtImportValidCs = new ExecutorCompletionService<>(bgtImportValidExecutor);
//
//        bgtImportValidCs.submit(()->{
//
//
//            return 1;
//        });
    }
}
