package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //1
        List<Student> students = StudentStorage.getStudents();
        System.out.println("students = " + students);
        Student student = new Student();
        student.setName("Viktor Demydenko");
        student.setEmail("viktordemydenko9519@gmail.com");
        student.setGithubAcc("https://github.com/viktorfrzn");
        student.setTelegramAcc("https://t.me/viktorviktor88");
        students.add(student);
        System.out.println("students = " + students);
       Student student1 = new Student();
        student1.setName("Illia Churkin");
        student1.setEmail("ilia.churkin88@gmail.com");
        student1.setGithubAcc("https://github.com/ilia88ilia");
        student1.setTelegramAcc("https://t.me/illia7777777");

       students.add(student1);
        System.out.println("students = " + students);

        Student getStudent = StudentStorage.getStudent("ilia.churkin88@gmail.com");

       System.out.println("getStudent = " + getStudent);


   //    student.name = "0000000000000000000";

        StudentInterface studentInterface = new StudentInterface();
        studentInterface.start();
    }
}