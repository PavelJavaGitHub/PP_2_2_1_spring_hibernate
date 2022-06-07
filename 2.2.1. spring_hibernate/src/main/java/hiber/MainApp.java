package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new Car("Mercedes", 600));
      userService.add(new Car("BMW", 7));
      userService.add(new Car("Lada", 9));
      userService.add(new Car("Zapor", 0));

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", userService.getCar(1L)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", userService.getCar(2L)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", userService.getCar(3L)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", userService.getCar(4L)));

      System.out.println();
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println();
      System.out.println(userService.getUserByCar("Mercedes", 600));
      System.out.println(userService.getUserByCar("BMW", 7));
      System.out.println(userService.getUserByCar("Lada", 9));
      System.out.println(userService.getUserByCar("Zapor", 0));
      System.out.println();

      context.close();
   }
}
