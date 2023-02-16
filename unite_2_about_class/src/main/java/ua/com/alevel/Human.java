package ua.com.alevel;

public class Human {
    String name;
    int age;

    long salary;

    boolean isMan = true;


    void drink()
    {
        System.out.println("Drink coca cola");

    }
    String info() {
        return "name = " + name + ", age = " + age + ", salary = " + salary + ", isMan = " + isMan;
    }
}
