package springbootdemo.controller;

import org.springframework.stereotype.Controller;
import springbootdemo.facade.Facade;

@Controller
public class UserController {
    Facade facade;

    public UserController(Facade facade) {
        this.facade = facade;
    }
}

