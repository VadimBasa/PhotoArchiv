package archive.facade;

import archive.dto.CreateUserRequestDTO;
import archive.dto.CreateUserResponseDTO;
import archive.service.AuthorizationService;
import archive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import archive.mapper.UserMapper;
import archive.model.User;

@Component
public class Facade implements FacadeInterface {
    @Autowired
    private final UserService userService;

    @Autowired
    private final AuthorizationService authorizationService;
    @Autowired
    private final UserMapper mapper;

    public Facade(UserService userService, AuthorizationService authorizationService, UserMapper mapper) {
        this.userService = userService;
        this.authorizationService = authorizationService;
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
    public void getAuthorities(String user, String password) {
        authorizationService.getAuthorities(user, password);}

    @Override
    public CreateUserResponseDTO updateUser(CreateUserResponseDTO dto, Long userId) {
        User user = userService.findById(userId);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setSecondName(dto.getSecondName());
        user.setFileName(dto.getFileName());
        user.setChapter(dto.getChapter());
        user.setMonth(dto.getManth());
        user.setComment(dto.getComment());
        user.setDateLoad(dto.getDateLoad());

        return mapper.responseToDto(userService.saveUser(user));
    }

}

