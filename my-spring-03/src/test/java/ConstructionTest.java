import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.NoSuchElementException;

/**
 * @author xxhstart
 * @create 2022-02-17 23:53
 * @description:
 */
public class ConstructionTest {

    @Test
    public void test11(){

        Class clazz = Student.class;

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        for (Constructor cons:declaredConstructors
             ) {
            System.out.println(cons);
            System.out.println("************");
            System.out.println(cons.getParameterTypes().length);
            System.out.println(cons.getParameterTypes());
            System.out.println("************");
        }




    }
}
