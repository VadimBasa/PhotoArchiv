package archive.facade;

import archive.dto.CreateUserRequestDTO;
import archive.dto.CreateUserResponseDTO;

public interface FacadeInterface {
    CreateUserRequestDTO saveUser(CreateUserRequestDTO dto);

    CreateUserResponseDTO updateUser(CreateUserResponseDTO dto, Long userId);

    CreateUserRequestDTO findById(Long id);

    // List<CreateUserResponseDTO> findAll();
    void deleteById(Long id);


   void getAuthorities(String user, String password);
}
