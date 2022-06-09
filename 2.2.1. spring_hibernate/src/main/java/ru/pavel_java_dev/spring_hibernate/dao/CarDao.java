package ru.pavel_java_dev.spring_hibernate.dao;

import ru.pavel_java_dev.spring_hibernate.model.Car;

import java.util.List;

public interface CarDao {

    void add(Car car);

    List<Car> listCars();

    Car getCar(Long id);
}
