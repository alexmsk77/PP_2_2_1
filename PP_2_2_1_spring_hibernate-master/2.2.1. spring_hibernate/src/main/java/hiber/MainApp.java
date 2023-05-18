package hiber;

import hiber.config.AppConfig;
import hiber.model.*;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Alex", "Petrov", "Petrov@mail.com"), new Car("Infiniti", 070));
      userService.add(new User("Petr", "Kvitov", "Petr@mail.ru"), new Car("Lada", 001));
      userService.add(new User("Carl", "Varov", "sidr@mail.com"), new Car("ZAZ", 3));
      userService.add(new User("Ivan", "Ivanov", "ivan@mail.ru"), new Car("BMW", 3));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
         System.out.println();
      }
      System.out.println("Driver car: \n"+ userService.getUserByCar("Lada",001));
      context.close();
   }
}