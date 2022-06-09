package ru.pavel_java_dev.spring_hibernate.service;

import ru.pavel_java_dev.spring_hibernate.model.Car;
import ru.pavel_java_dev.spring_hibernate.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserByCar(String model, int series);
}
