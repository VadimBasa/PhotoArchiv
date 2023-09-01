package springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springbootdemo.facade.Facade;
import springbootdemo.mapper.UserMapper;
import springbootdemo.service.UserService;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class UserCrudApplication {
    @Bean
    public Facade facade(UserService userService, UserMapper userMapper) {//, Model model
        return new Facade(userService, userMapper);//, model
    }


    @Bean // добавление бина в application
    public ModelMapper getMapper() {
        return new ModelMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class, args);
    }

}
