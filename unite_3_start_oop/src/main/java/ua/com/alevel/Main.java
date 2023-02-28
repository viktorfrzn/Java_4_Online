package ua.com.alevel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = 1000;
        Random random = new Random();
        Test[] tests = new Test[random.nextInt(count)];
        System.out.println("tests = " + tests.length);

        for (int i = 0; i < tests.length; i++) {
            tests[i] = new Test();
            tests[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(2);
            if (result == 0) {
                tests[i].isStupid = true;
            } else {
                tests[i].isStupid = false;
            }
        }

        for (int i = 0; i < tests.length; i++) {
            System.out.println(
                    "tests = " + tests[i].name + " " + tests[i].isStupid
            );
        }


//        Human h1 = new Human();
//        h1.setName("Roma");
//        char[] oldName1 = new char[4];
//        oldName1[0] = 'G';
//        oldName1[1] = 'A';
//        oldName1[2] = 'B';
//        oldName1[3] = 'E';
//        char[] oldName2 = new char[]{ 'G', 'A', 'B', 'E' };

//        System.out.print("oldName = ");
//        for (int i = 0; i < oldName2.length; i++) {
//            System.out.print(oldName2[i]);
//        }

//        int a = 10;
//        Random random = new Random();
//        int rand = random.nextInt(2);
//        System.out.println("rand = " + rand);


//        Human h2 = new Human();
//        Human h2 = h1;
//        h2.setName("Viktor");
//        System.out.println("h1 = " + h1.getName());
//        System.out.println("h2 = " + h2.getName());
    }
}