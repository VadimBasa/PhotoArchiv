package archive.mapper;

import archive.dto.CreateUserRequestDTO;
import archive.dto.CreateUserResponseDTO;
import archive.model.Authorities;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import archive.model.User;

import java.util.Objects;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Component
public class UserMapper {


    public User toEntity(CreateUserRequestDTO dto) {
        ModelMapper mapper = getModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }
   /* public Authorities toEntityAuthorities(CreateUserRequestDTO dto) {
        ModelMapper mapper = getModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(dto) ? null : mapper.map(dto, Authorities.class);
    }*/
    public CreateUserRequestDTO toDto(User entity) {
        ModelMapper mapper = getModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(entity) ? null : mapper.map(entity, CreateUserRequestDTO.class);
    }

    public CreateUserResponseDTO responseToDto(User entity) {
        ModelMapper mapper = getModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(entity) ? null : mapper.map(entity, CreateUserResponseDTO.class);
    }

    private ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }
}

