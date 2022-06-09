package ru.pavel_java_dev.spring_hibernate.dao;

import ru.pavel_java_dev.spring_hibernate.model.Car;
import ru.pavel_java_dev.spring_hibernate.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   List<User> listUsers();

   Car getCar(Long id);

   User getUserByCar(String model, int series);
}
