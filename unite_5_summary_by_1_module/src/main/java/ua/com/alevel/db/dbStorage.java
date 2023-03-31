package ua.com.alevel.db;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class dbStorage {

    private static List<Student> students = new ArrayList<>();
    private static List<Course> course = new ArrayList<>();

    private dbStorage() { }

    public void addStudent(Student student) {
        students.add(student);


        public static Student getStudent(String id) {
            return students.
                    stream().
                    filter(student1 -> student1.getId().equals(id).
                    findFirst()
                    .get();

        }
    }
    }

}
