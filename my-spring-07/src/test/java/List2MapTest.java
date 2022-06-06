import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-06 15:32
 */
public class List2MapTest {


    @Test
    public void test1111() {
        List<User> users = Arrays.asList(
                new User(101, "Jack"),
                new User(102, "Kreas"),
                new User(103, "Marry"),
                new User(104, "Timi"),
                new User(105, "Alice"));

        Map<User, User> collect = users.parallelStream().collect(Collectors.toMap(k -> k, v -> v, (v1, v2) -> v1));

//        for (User user : collect.values()) {
//            System.out.println(user);
//        }
//        for (User user:collect.keySet()){
//            System.out.println(user);
//        }
        Object[] objects1 = collect.values().toArray();
        Object[] objects = collect.keySet().toArray();

        for (int i = 0;i< collect.keySet().size();i++){
            System.out.println("********");
            System.out.println(objects[i]);

            System.out.println(objects1[i]);
            System.out.println("********");
        }

    }

}
