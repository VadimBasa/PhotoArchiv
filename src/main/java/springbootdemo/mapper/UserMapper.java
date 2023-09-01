package springbootdemo.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.dto.CreateUserResponseDTO;
import springbootdemo.model.User;

import java.util.Objects;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public User toEntity(CreateUserRequestDTO dto) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    public CreateUserRequestDTO toDto(User entity) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(entity) ? null : mapper.map(entity, CreateUserRequestDTO.class);
    }

    public CreateUserResponseDTO responseToDto(User entity) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(entity) ? null : mapper.map(entity, CreateUserResponseDTO.class);
    }
}

