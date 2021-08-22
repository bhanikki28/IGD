package model;

public class Celebrity {

    private String name;
    private String sport;
    private int age;
    private long salary;

    public Celebrity(String name, String sport, int age, long salary) {
        this.name = name;
        this.sport = sport;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "name='" + name + '\'' +
                ", sport='" + sport + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
