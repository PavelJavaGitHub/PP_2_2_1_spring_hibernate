package ru.pavel_java_dev.spring_hibernate.service;

import ru.pavel_java_dev.spring_hibernate.model.Car;

import java.util.List;

public interface CarService {

    void add(Car car);

    List<Car> listCars();

    Car getCar(Long id);
}
