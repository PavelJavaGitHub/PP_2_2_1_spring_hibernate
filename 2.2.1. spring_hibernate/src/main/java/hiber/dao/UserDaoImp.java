package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) { sessionFactory.getCurrentSession().save(car); }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      String hql = "from User";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      return query.getResultList();
   }

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
