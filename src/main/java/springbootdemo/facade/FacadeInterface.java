package springbootdemo.facade;

import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;

public interface FacadeInterface {
    CreateUserRequestDTO saveUser(CreateUserRequestDTO dto);
    CreateUserResponseDTO updateUser(CreateUserResponseDTO dto, Long userId) ;
    CreateUserRequestDTO findById(Long id);
   // List<CreateUserResponseDTO> findAll();
    CreateUserResponseDTO deleteById(Long id);
}
