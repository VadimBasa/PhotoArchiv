package springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springbootdemo.facade.Facade;
import springbootdemo.model.User;
import springbootdemo.service.UserService;


@SpringBootApplication
public class UserCrudApplication {
    @Bean
    public Facade facade(UserService userService) {
        return new Facade(userService);
    }
   /*@Bean
    public User user() {return new User();}*/

    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class, args);


    }

}
