package springbootdemo.facade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootdemo.exception.InvalidCredentials;
import springbootdemo.exception.UnauthorizedUser;
import springbootdemo.model.Authorities;
import springbootdemo.model.User;
import springbootdemo.service.AuthorizationService;
import springbootdemo.service.UserService;

import java.util.List;

public class Facade {
    private UserService userService;

    private AuthorizationService authorizationService;// - второй этап, добавить сервис авторизации

    public Facade() {
        this.userService = userService;
        this.authorizationService = authorizationService;
    }

    public void findById(Long id, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        userService.findById(id);
    }

    public List<User> findAll() {

        return userService.findAll();
    }

    public void createUser() {
        //User user = new User();
        userService.saveUser();
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public void updateUserForm(Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
    }

    public void updateUser() {
        userService.saveUser();
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return authorizationService.getAuthorities(user, password);
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

