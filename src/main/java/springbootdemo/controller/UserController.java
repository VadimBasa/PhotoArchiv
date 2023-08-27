package springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.facade.Facade;
//import springbootdemo.model.User;
//import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
@RestController

public class UserController {
    @Autowired
    private Facade facade;

   @GetMapping("/user-create")
   public ResponseEntity<CreateUserRequestDTO> createUserForm(CreateUserRequestDTO dto) {
       System.out.println("I am controller and create user" + dto.getFirstName());
       facade.saveUser(dto);
       //return "user-create";
       return ResponseEntity.ok().body(dto);
       //return String.valueOf(ResponseEntity.status(201).body(facade.findAll()));
   }
// метод create
    @PostMapping("/user-create")
    public ResponseEntity<CreateUserRequestDTO> saveUser(@RequestBody @Valid CreateUserRequestDTO userDTO)  {
        System.out.println("I am controller and create user " + userDTO);
        CreateUserRequestDTO u = facade.saveUser(userDTO);
        //return "redirect:/users";
        return ResponseEntity.status(201).body(u);
    }
    // метод delete
    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        facade.deleteById(id);
        return "redirect:/users";
    }

      // метод update
   @PutMapping("/user-update/{id}")
    public String findById(CreateUserRequestDTO dto, @PathVariable("id")  Long id) {
        facade.updateUser(dto);
        return "redirect:/users";
    }
// метод read
@GetMapping("/user/{id}")
public String findUser(CreateUserRequestDTO dto, @PathVariable("id")  Long id) {
    facade.findById(dto, id);
    return "user-list";
    //return String.valueOf(ResponseEntity.ok().body(facade.findAll()));
    //ResponseEntity.status(201).body(p)
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

