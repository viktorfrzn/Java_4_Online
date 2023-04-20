package ua.com.alevel;

import ua.com.alevel.controller.ServiceController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServiceController serviceController = new ServiceController();
        serviceController.start();
    }
}