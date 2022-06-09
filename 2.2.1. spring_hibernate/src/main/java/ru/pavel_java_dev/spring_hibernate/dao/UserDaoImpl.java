package ru.pavel_java_dev.spring_hibernate.dao;

import ru.pavel_java_dev.spring_hibernate.model.Car;
import ru.pavel_java_dev.spring_hibernate.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        String hql = "from User";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Car getCar(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    public User getUserByCar(String model, int series) {
        String hql = "from User as user\n" +
                "where user.car = (\n from Car as car\n" +
                "\twhere car.model = :model and car.series = :series)";

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }
}
