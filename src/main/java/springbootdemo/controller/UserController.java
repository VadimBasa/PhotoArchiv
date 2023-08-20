package springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootdemo.exception.InvalidCredentials;
import springbootdemo.exception.UnauthorizedUser;
import springbootdemo.facade.Facade;
import springbootdemo.model.Authorities;
import springbootdemo.model.User;
//import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
@RestController
//@RequestMapping("/")
public class UserController {
    @Autowired
    private Facade facade;
    //Facade facade;

    //public UserController(Facade facade) {
    //    this.facade = facade;
   // }

   /* @GetMapping("/hello")
    public String ok() {
        facade.findAll();
        return "user-list";
        //return String.valueOf(ResponseEntity.ok());//.body(facade.findAll())
        //ResponseEntity.status(201).body(p)
    }*/
   @GetMapping("/user-create")
   public String createUserForm(User user) {
       System.out.println("I am controller and create user" + user.getFirstName());
       facade.saveUser(user);
       return "user-create";
       //return String.valueOf(ResponseEntity.status(201).body(facade.findAll()));
   }

    @GetMapping("/users")
    public String findAll() {
        facade.findAll();
        return "user-list";
        //return String.valueOf(ResponseEntity.ok().body(facade.findAll()));
        //ResponseEntity.status(201).body(p)
    }



    @PostMapping("/user-create")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        System.out.println("I am controller and create user " + user.getFirstName());
       User u = facade.saveUser(user);
        //return "redirect:/users";
        return ResponseEntity.status(201).body(u);

        //return null;
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
    public String updateUser(User user) {
        facade.updateUser(user);
        return "redirect:/users";
    }

  /*  @GetMapping("/authorize")
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
    }*/
}

