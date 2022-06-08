/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-08 22:02
 */
public class Curry {

    private String name;

    private Integer age;

    public Curry(){

    }

    public Curry(String name, Integer age) {
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
}
