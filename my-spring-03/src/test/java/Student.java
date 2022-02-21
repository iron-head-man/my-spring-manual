/**
 * @author xxhstart
 * @create 2022-02-17 23:53
 * @description:
 */
public class Student {

    private String name;

    private Integer age;

    private String grade;

    public Student(String name) {
        this.name = name;
    }

    public Student(Integer age) {
        this.age = age;
    }

    public Student(Integer age, String grade) {
        this.age = age;
        this.grade = grade;
    }

    public Student(String name, Integer age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
