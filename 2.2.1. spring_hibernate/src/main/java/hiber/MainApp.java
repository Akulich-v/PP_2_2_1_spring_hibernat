package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
//import hiber.repository.CarRepository;
//import hiber.repository.UserRepository;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));



      Car car = new Car("Tesla", 12345);
      Car car1 = new Car("Opel", 44444);
      User user1 = new User("Имя","Фамилия","Почта@mail.ru");
      User user2 = new User("Имя1","Фамилия1","Почта1@mail.ru");

      user1.setCar(car);
      user2.setCar(car1);

      userService.add(user1);
      userService.add(user2);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
