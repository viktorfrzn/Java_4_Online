package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class DdCar {
    private final List<Car> cars = new ArrayList<>();
    private static DdCar instance;

    private DdCar() {}

    public static DdCar getInstance() {
        if (instance == null) {
            instance = new DdCar();
        }
        return instance;
    }

    public void create(Car car) {
        car.setId(BaseEntity.generateId());
        cars.add(car);
    }

    public List<Car> findAll() {
        return cars;
    }

    public void delete(Car car) {
        cars.remove(car);
    }
}
