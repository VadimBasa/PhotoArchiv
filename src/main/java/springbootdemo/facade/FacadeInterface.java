package springbootdemo.facade;

import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.model.User;

import java.util.List;

public interface FacadeInterface {
    CreateUserRequestDTO saveUser(CreateUserRequestDTO dto);
    CreateUserRequestDTO updateUser(CreateUserRequestDTO dto);
    CreateUserRequestDTO findById(CreateUserRequestDTO dto, Long id);
   // List<CreateUserResponseDTO> findAll();
    void deleteById(Long id);
}
