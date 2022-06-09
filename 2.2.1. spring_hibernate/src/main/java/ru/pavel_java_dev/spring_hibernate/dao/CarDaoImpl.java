package ru.pavel_java_dev.spring_hibernate.dao;

import ru.pavel_java_dev.spring_hibernate.model.Car;
import ru.pavel_java_dev.spring_hibernate.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) { sessionFactory.getCurrentSession().save(car); }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        String hql = "from Car";
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Car getCar(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }
}
