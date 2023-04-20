package ua.com.alevel.service;

import ua.com.alevel.dao.DaoGarageCar;
import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Garage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceGarageCar {
    private final Rules rules = new Rules();
    private final DaoGarageCar dao = new DaoGarageCar();

    public void exit() {
        System.exit(0);
    }

    public void attachCarToGarage(String garageId, String carId) {
        Optional<Car> car = findCarById(carId);
        if (car.isEmpty()) {
            System.out.println("This car id is incorrect");
            return;
        }
        if (car.get().getGarage() != null) {
            findGarageById(car.get().getId()).ifPresent(e -> e.deleteCar(car.get()));
        }
        Optional<Garage> garage = findGarageById(garageId);
        if (garage.isEmpty()) {
            System.out.println("This garage id is incorrect");
            return;
        }
        if (garage.get().getCapacity() == garage.get().getCarsInside().size()) {
            System.out.println("This garage is full");
            return;
        }
        car.get().setGarage(garage.get());
        garage.get().addCar(car.get());
    }

    public void cleanGarage(String id) {
        Optional<Garage> garage = findGarageById(id);
        if (garage.isEmpty()) {
            System.out.println("This id is incorrect");
        } else {
            garage.get().getCarsInside().forEach(Car::removeGarage);
            garage.get().getCarsInside().clear();
        }
    }

    public void deleteCarFromGarage(String garageId, String carId) {
        Optional<Garage> garage = findGarageById(garageId);
        if (garage.isEmpty()) {
            System.out.println("This garage id is incorrect");
            return;
        }
        Optional<Car> car = findCarById(carId);
        if (car.isEmpty()) {
            System.out.println("This car id is incorrect");
            return;
        }
        garage.get()
                .getCarsInside()
                .removeIf(e -> e.getId().equals(car.get().getId()));
        car.get().removeGarage();
    }

    public List<Car> readCarsInGarage(String id) {
        Optional<Garage> garage = findGarageById(id);
        if (garage.isPresent()) {
            return garage.get().getCarsInside();
        } else {
            System.out.println("This id is incorrect");
            return new ArrayList<>();
        }
    }

    public void removeGarage(String id) {
        Optional<Garage> optional = findGarageById(id);
        optional.ifPresent(dao::removeGarage);
    }

    public void upgradeGarage(Garage garage) {
        if (garage == null) {
            System.out.println("Something went wrong");
            return;
        }
        if (rules.garageAddressIsInvalid(garage.getAddress())) {
            System.out.println("This address is incorrect");
            garage.setAddress(Rules.DEFAULT_GARAGE_ADDRESS);
        } else if (rules.garageCapacityIsInvalid(garage.getCapacity())) {
            System.out.println("This capacity is incorrect");
            garage.setCapacity(Rules.DEFAULT_GARAGE_CAPACITY);
        } else if (rules.garageNameIsInvalid(garage.getName())) {
            System.out.println("This name is incorrect");
            garage.setName(Rules.DEFAULT_GARAGE_NAME);
        }
    }

    public List<Garage> findAllGarages() {
        return dao.findAllGarages();
    }

    public Optional<Garage> findGarageById(String id) {
        return dao.findAllGarages()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public void createGarage(Garage garage) {
        if (garage == null) {
            System.out.println("Something went wrong, please try again");
            return;
        }
        if (rules.garageNameIsInvalid(garage.getName())) {
            System.out.println("This name is incorrect");
            garage.setName(Rules.DEFAULT_GARAGE_NAME);
        }
        if (rules.garageAddressIsInvalid(garage.getAddress())) {
            System.out.println("This address is incorrect");
            garage.setAddress(Rules.DEFAULT_GARAGE_ADDRESS);
        }
        if (rules.garageCapacityIsInvalid(garage.getCapacity())) {
            System.out.println("This capacity is incorrect");
            garage.setCapacity(Rules.DEFAULT_GARAGE_CAPACITY);
        }
        dao.createGarage(garage);
    }

    public void removeCar(String id) {
        Optional<Car> optional = findCarById(id);
        optional.ifPresent(dao::removeCar);
    }


    public void upgradeCar(Car car) {
        if (car == null) {
            System.out.println("Something went wrong");
            return;
        }
        if (rules.carBrandIsInvalid(car.getBrand())) {
            System.out.println("This brand is incorrect");
            car.setBrand(Rules.DEFAULT_CAR_BRAND);
        } else if (rules.carColorIsInvalid(car.getColor())) {
            System.out.println("This color is incorrect");
            car.setColor(Rules.DEFAULT_CAR_COLOR);
        } else if (rules.carCountryIsInvalid(car.getCountry())) {
            System.out.println("This country is incorrect");
            car.setCountry(Rules.DEFAULT_CAR_COUNTRY);
        } else if (rules.carFuelIsInvalid(car.getFuel())) {
            System.out.println("This fuel is incorrect");
            car.setFuel(Rules.DEFAULT_CAR_FUEL);
        }
    }

    public List<Car> findAllCars() {
        return dao.findAllCars();
    }

    public Optional<Car> findCarById(String id) {
        return dao.findAllCars()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public void createCar(Car car) {
        if (car == null) {
            System.out.println("Something went wrong, please try again!");
            return;
        }
        if (rules.carBrandIsInvalid(car.getBrand())) {
            System.out.println("This brand is incorrect");
            car.setBrand(Rules.DEFAULT_CAR_BRAND);
        }
        if (rules.carCountryIsInvalid(car.getCountry())) {
            System.out.println("This country is incorrect");
            car.setCountry(Rules.DEFAULT_CAR_COUNTRY);
        }
        if (rules.carFuelIsInvalid(car.getFuel())) {
            System.out.println("This fuel is incorrect");
            car.setFuel(Rules.DEFAULT_CAR_FUEL);
        }
        if (rules.carColorIsInvalid(car.getColor())) {
            System.out.println("This color is incorrect");
            car.setColor(Rules.DEFAULT_CAR_COLOR);
        }
        dao.createCar(car);
    }
}