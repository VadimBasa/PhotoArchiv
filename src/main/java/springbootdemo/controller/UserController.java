package springbootdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootdemo.exception.InvalidCredentials;
import springbootdemo.exception.UnauthorizedUser;
import springbootdemo.facade.Facade;
import springbootdemo.model.Authorities;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    Facade facade;

    public UserController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping("/hello")
    public String ok() {
        facade.findAll();
        return "user-list";
        //return String.valueOf(ResponseEntity.ok());//.body(facade.findAll())
        //ResponseEntity.status(201).body(p)
    }

    @GetMapping("/users")
    public String findAll() {
        facade.findAll();
        return "user-list";
        //return String.valueOf(ResponseEntity.ok().body(facade.findAll()));
        //ResponseEntity.status(201).body(p)
    }

    @GetMapping("/user-create")
    public String createUserForm() {
        facade.createUser();
        //return "user-create";
        return String.valueOf(ResponseEntity.status(201).body(facade.findAll()));
    }

    @PostMapping("/user-create")
    public String createUser() {
        facade.createUser();
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        facade.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String findById(Long id, Model model) {
        facade.updateUserForm(id, model);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser() {
        facade.updateUser();
        return "redirect:/users";
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return facade.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}

