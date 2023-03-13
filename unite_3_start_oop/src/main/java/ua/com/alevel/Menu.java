package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println();
        System.out.println("Select what do you want yo do: ");
        String select;
        operationList();
        while ((select = reader.readLine()) != null) {
            operationMenu(reader, select);
        }
    }
    private void operationList() {
        System.out.println();
        System.out.println("###Click if you want to know the sum of the digits in your line ------------ Enter 1");
        System.out.println();
        System.out.println("###Click to sort repeated characters in a string ------- Enter 2");
        System.out.println();
        System.out.println("###Click to find out what time the lesson ends ------------------ Enter 3");
        System.out.println();
        System.out.println("###Click if you want to EXIT ---------------------------------------------Enter 4");
    }
    public void operationMenu(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1": SumDigit.enterString(reader); break;
            case "2": SymbolSort.enterString(reader); break;
            case "3": EndLess.enterString(reader); break;
            case "0" : stop(); break;
        }
        operationList();
    }

    private void stop() {
        System.out.println("Good bye!!!");
        System.exit(0);
    }
}