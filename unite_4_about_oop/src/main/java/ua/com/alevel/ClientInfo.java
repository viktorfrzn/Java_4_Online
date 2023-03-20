package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClientInfo {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Data Base");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    public void menu() {
        System.out.println();
        System.out.println("Add to Client Data Base Enter 1");
        System.out.println("Show all Clients of This Store Enter 2");
        System.out.println("Find The Client by Email Enter 3");
        System.out.println("Delete User From Base Enter 4");
        System.out.println("Exit Enter 0");
        System.out.println();
    }
}
