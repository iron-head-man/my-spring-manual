/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-06 15:32
 */
public class User {

    private String name;
    private Integer age;

    public User(Integer age, String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
