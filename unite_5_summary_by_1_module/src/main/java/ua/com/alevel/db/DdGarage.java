package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Garage;

import java.util.ArrayList;
import java.util.List;

public class DdGarage {
    private final List<Garage> garages = new ArrayList<>();
    private static DdGarage instance;

    private DdGarage() {}

    public static DdGarage getInstance() {
        if (instance == null) {
            instance = new DdGarage();
        }
        return instance;
    }

    public void create(Garage garage) {
        garage.setId(BaseEntity.generateId());
        garages.add(garage);
    }

    public List<Garage> findAll() {
        return garages;
    }

    public void delete(Garage garage) {
        garages.remove(garage);
    }
}