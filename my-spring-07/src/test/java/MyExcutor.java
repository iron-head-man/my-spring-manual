/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-24 23:38
 */
public class MyExcutor implements Runnable{

    private String name;

    public MyExcutor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Integer age;

    @Override
    public void run() {

        System.out.println("我的名字是"+name);
        System.out.println("我的年龄是"+age);

    }
}
