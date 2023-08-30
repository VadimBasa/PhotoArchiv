package springbootdemo.facade;

import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.mapper.UserMapper;
import springbootdemo.model.User;
import springbootdemo.service.UserService;


public class Facade implements FacadeInterface{
    private final UserService userService;
    private final UserMapper mapper;
    public Facade(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public CreateUserRequestDTO saveUser(CreateUserRequestDTO dto) {
        System.out.println("I am facade and create user");
        return mapper.toDto(userService.saveUser(mapper.toEntity(dto)));

    }

    @Override
    public CreateUserRequestDTO findById(Long id) {
        return mapper.toDto(userService.findById(id));
    }

 /*   @Override
    public List<CreateUserResponseDTO> findAll() {
        CreateUserResponseDTO dto;
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return UserMapper.MapperUtil.convertList(users,dtoUser); //mapper.toDto(userService.findAll());
    }*/


    @Override
    public CreateUserResponseDTO deleteById(Long id) {
        userService.deleteById(id);
        return null;
    }

    @ Override
    public CreateUserResponseDTO updateUser(CreateUserResponseDTO dto, Long userId) {
        User user = userService.findById(userId);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setSex(dto.getSex());
        user.setAge(dto.getAge());
        return mapper.responseToDto(userService.saveUser(user));
    }

}

