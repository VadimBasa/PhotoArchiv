package springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.facade.Facade;
import javax.validation.Valid;
@RestController

public class UserController {
    @Autowired
    private Facade facade;

   @GetMapping("/user-create")
   public ResponseEntity<CreateUserRequestDTO> getUser(CreateUserRequestDTO dto) {
       facade.saveUser(dto);
       return ResponseEntity.ok().body(dto);
   }
// метод create
    @PostMapping("/user-create")
    public ResponseEntity<CreateUserRequestDTO> saveUser(@RequestBody @Valid CreateUserRequestDTO userDTO)  {
        CreateUserRequestDTO u = facade.saveUser(userDTO);
        return ResponseEntity.status(201).body(u);
    }
    // метод delete
    @DeleteMapping("user-delete/{id}")
    public ResponseEntity<CreateUserResponseDTO>   deleteUser(@PathVariable("id") Long id) {
        CreateUserResponseDTO dto = facade.deleteById(id);
        return ResponseEntity.ok().body(dto);
    }

      // метод update
   @PutMapping("/user-update/{id}")
   public ResponseEntity<CreateUserResponseDTO>  updateUser(CreateUserResponseDTO dto, @PathVariable("id")  Long id) {
       return ResponseEntity.ok().body(facade.updateUser(dto, id));
   }

    // метод read
@GetMapping("/users/{id}")
public ResponseEntity<CreateUserRequestDTO>  findById(@PathVariable("id")  Long id) {
    CreateUserRequestDTO p = facade.findById(id);
    return ResponseEntity.status(200).body(p);
}

}

