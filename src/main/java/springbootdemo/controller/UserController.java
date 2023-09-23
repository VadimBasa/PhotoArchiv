package springbootdemo.controller;

import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class UserController {
    @Autowired
    private Facade facade;

    @GetMapping("/user-create")
    public ResponseEntity<CreateUserRequestDTO> getUser(@RequestBody @Valid CreateUserRequestDTO dto) {
        facade.saveUser(dto);
        return ResponseEntity.ok().body(dto);
    }

    // метод create
    @PostMapping("/user-create")
    public ResponseEntity<CreateUserRequestDTO> saveUser(@RequestBody @Valid CreateUserRequestDTO userDTO) {
        CreateUserRequestDTO u = facade.saveUser(userDTO);
        return ResponseEntity.status(201).body(u);
    }

    // метод delete
    @DeleteMapping("user-delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        facade.deleteById(id);

    }

    // метод update
    @PutMapping("/user-update/{id}")
    public ResponseEntity<CreateUserResponseDTO> updateUser(@RequestBody @Valid CreateUserResponseDTO dto, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(facade.updateUser(dto, id));
    }

    // метод read
    @GetMapping("/users/{id}")
    public ResponseEntity<CreateUserRequestDTO> findById(@PathVariable("id") Long id) {
        CreateUserRequestDTO p = facade.findById(id);
        return ResponseEntity.status(200).body(p);
    }

}

