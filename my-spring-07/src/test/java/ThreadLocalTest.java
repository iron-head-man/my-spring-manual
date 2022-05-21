import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-21 20:24
 */
public class ThreadLocalTest {


    @Test
    public void test11(){

        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("wade");
        objectThreadLocal.set("kobe");
        objectThreadLocal.get();

        String s = "=12345=";
        Long.parseLong(s);

    }
}
