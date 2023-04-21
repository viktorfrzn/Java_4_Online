package ua.com.alevel.controller;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Garage;
import ua.com.alevel.controller.ServiceController;
import ua.com.alevel.service.Rules;
import ua.com.alevel.service.ServiceGarageCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class ServiceController {
    private final ServiceGarageCar service = new ServiceGarageCar();

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose option");
        String line;
        menu();
        while ((line = reader.readLine()) != null) {
            crud(reader, line);
        }
    }

    private void crud(BufferedReader reader, String option) throws IOException {
        switch (option.trim()) {
            case "1" -> createCar(reader);
            case "2" -> upgradeCar(reader);
            case "3" -> findCar(reader);
            case "4" -> findAllCars();
            case "5" -> removeCar(reader);
            case "6" -> exit();
        }
        menu();
    }

    private void removeCar(BufferedReader reader) throws IOException {
        System.out.println("Please enter the car id");
        service.removeCar(reader.readLine().trim());
    }

    private void findAllCars() {
        System.out.println(Car.CAR_UTIL);
        for (Car car : service.findAllCars()) {
            System.out.println(car);
        }
    }

    private void findCar(BufferedReader reader) throws IOException {
        System.out.println("Please enter the car id");
        Optional<Car> car = service.findCarById(reader.readLine().trim());
        if (car.isEmpty()) {
            System.out.println("This id is incorrect");
        } else {
            System.out.println(Car.CAR_UTIL);
            System.out.println(car.get());
        }
    }

    private void upgradeCar(BufferedReader reader) throws IOException {
        System.out.println("Please enter the car id");
        String id = reader.readLine();
        if (id == null) return;
        Optional<Car> optional = service.findCarById(id);
        if (optional.isEmpty()) {
            System.out.println("This id is incorrect");
        } else {
            upgradeCarMenu();
            String option = reader.readLine().trim();
            System.out.println("PLease enter the new value");
            switch (option) {
                case "1" -> optional.get().setBrand(reader.readLine().trim());
                case "2" -> optional.get().setFuel(reader.readLine());
                case "3" -> optional.get().setCountry(reader.readLine());
                case "4" -> optional.get().setColor(reader.readLine());
            }
            service.upgradeCar(optional.get());
        }
    }

    private void upgradeCarMenu() {
        System.out.println("To upgrade brand, please enter 1");
        System.out.println("To upgrade fuel, please enter 2");
        System.out.println("To upgrade country, please enter 3");
        System.out.println("To upgrade color, please enter 4");
    }

    private void createCar(BufferedReader reader) throws IOException {
        Car car = new Car();
        System.out.println("Please enter the brand");
        car.setBrand(reader.readLine().trim());
        System.out.println("Please enter the country");
        car.setCountry(reader.readLine().trim());
        System.out.println("Please enter the fuel");
        car.setFuel(reader.readLine().trim());
        System.out.println("Please enter the color");
        car.setColor(reader.readLine().trim());
        service.createCar(car);
    }

    private void exit() {
        service.exit();
    }

    private void menu() {
        System.out.println();
        System.out.println("-------------MENU---------------");
        System.out.println("Create a car,please enter ---  1");
        System.out.println("Upgrade the car,please enter - 2");
        System.out.println("Find the car,please enter ---  3");
        System.out.println("Find all cars,please enter --- 4");
        System.out.println("Remove the car,please enter -- 5");
        System.out.println("Close application,please enter 6");
        System.out.println("---------------------------------");
        System.out.println();
    }
}