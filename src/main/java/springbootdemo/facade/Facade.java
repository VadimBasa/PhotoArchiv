package springbootdemo.facade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.exception.InvalidCredentials;
import springbootdemo.exception.UnauthorizedUser;
import springbootdemo.mapper.UserMapper;
import springbootdemo.model.Authorities;
import springbootdemo.model.User;
import springbootdemo.service.AuthorizationService;
import springbootdemo.service.ServiceUserInterface;
import springbootdemo.service.UserService;
import org.modelmapper.ModelMapper;
import javax.validation.Valid;
import java.util.List;


public class Facade implements FacadeInterface{
    private UserService userService;
    private Model model;
    //private AuthorizationService authorizationService;// - второй этап, добавить сервис авторизации
    private UserMapper mapper;
   // private CreateUserRequestDTO dtoUser;
    public Facade(UserService userService, UserMapper mapper, Model model) {//, CreateUserRequestDTO dtoUser
        this.userService = userService;
        this.mapper = mapper;
        this.model = model;
       // this.dtoUser = dtoUser;
       //this.authorizationService = authorizationService;
    }

    @Override
    public CreateUserRequestDTO saveUser(CreateUserRequestDTO dto) {
        //User user ;
        System.out.println("I am facade and create user");

        //user = userService.saveUser(user);
        return mapper.toDto(userService.saveUser(mapper.toEntity(dto)));

    }

    @Override
    public CreateUserRequestDTO findById(CreateUserRequestDTO dto, Long id) {//public User findById(Long id, Model model) {
        //CreateUserRequestDTO dto;
       // mapper.toEntity(dto);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        UserMapper.MapperUtil.convertList(users, dto);
        return mapper.toDto(userService.findById(id));
    }

 /*   @Override
    public List<CreateUserResponseDTO> findAll() {
        CreateUserResponseDTO dto;
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return UserMapper.MapperUtil.convertList(users,dtoUser); //mapper.toDto(userService.findAll());
    }*/

   /* @Override
    public List<User> findAll() {

        return userService.findAll();
    }*/


    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    /*public void updateUserForm(Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
    }*/

    /*public void updateUser(User user) {
        userService.saveUser(user);
    }*/
    @ Override
    public CreateUserRequestDTO updateUser(CreateUserRequestDTO dto) {
        return mapper.toDto(userService.saveUser(mapper.toEntity(dto)));

    }


  /*  @GetMapping("/authorize")
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
    }*/

}

