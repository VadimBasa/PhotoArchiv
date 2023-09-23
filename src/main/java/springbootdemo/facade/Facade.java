package springbootdemo.facade;

import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbootdemo.mapper.UserMapper;
import springbootdemo.model.User;

@Component
public class Facade implements FacadeInterface {
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserMapper mapper;

    public Facade(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public CreateUserRequestDTO saveUser(CreateUserRequestDTO dto) {
        return mapper.toDto(userService.saveUser(mapper.toEntity(dto)));
    }

    @Override
    public CreateUserRequestDTO findById(Long id) {
        return mapper.toDto(userService.findById(id));
    }


    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @Override
    public CreateUserResponseDTO updateUser(CreateUserResponseDTO dto, Long userId) {
        User user = userService.findById(userId);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setSex(dto.getSex());
        user.setAge(dto.getAge());
        return mapper.responseToDto(userService.saveUser(user));
    }

}

