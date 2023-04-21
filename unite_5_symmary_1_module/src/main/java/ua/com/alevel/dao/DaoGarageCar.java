package ua.com.alevel.dao;

import ua.com.alevel.db.DdCar;
import ua.com.alevel.db.DdGarage;
import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Garage;

import java.util.List;

public class DaoGarageCar {
    DdCar dbCar = DdCar.getInstance();
    DdGarage dbGarage = DdGarage.getInstance();

    public void createCar(Car car) {
        dbCar.create(car);
    }

    public List<Car> findAllCars() {
        return dbCar.findAll();
    }

    public void removeCar(Car car) {
        findAllGarages()
                .stream()
                .filter(e -> e.getCarsInside().contains(car))
                .forEach(e -> e.deleteCar(car));
        dbCar.delete(car);
    }

    public void createGarage(Garage garage) {
        dbGarage.create(garage);
    }

    public List<Garage> findAllGarages() {
        return dbGarage.findAll();
    }

    public void removeGarage(Garage garage) {
        findAllCars()
                .stream()
                .filter(e -> e.getGarage() != null)
                .filter(e -> garage.getId().equals(e.getGarage().getId()))
                .findAny()
                .ifPresent(Car::removeGarage);
        dbGarage.delete(garage);
    }
}