package springbootdemo.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springbootdemo.dto.CreateUserRequestDTO;
import springbootdemo.model.User;

import java.util.Objects;

import static org.apache.tomcat.jni.SSLConf.apply;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    //@Override
    public User toEntity(CreateUserRequestDTO dto) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

   // @Override
    public CreateUserRequestDTO toDto(User entity) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return Objects.isNull(entity) ? null : mapper.map(entity, CreateUserRequestDTO.class);
    }
   /* public Converter< CreateUserRequestDTO, User> toEntityConverter() {
        return context -> {
            CreateUserRequestDTO source = context.getSource();
            User destination = context.getDestination();
            //mapSpecificFields(source, destination);
            return destination;
        };
    }

    public Converter<User, CreateUserRequestDTO > toDtoConverter() {
        return context -> {
            User source = context.getSource();
            CreateUserRequestDTO destination = context.getDestination();
            //mapSpecificFields(source, destination);
            return destination;
        };
    }*/
    @Configuration
    public class MapperUtil {

       public static <R, E> List<R> convertList(List<E> list, Function<E, R> converter) {
           return list.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
       }
       /* public static <R, E> List<R> convertList(List<User> list, CreateUserRequestDTO converter) {
            return list.stream().map(e -> converter. apply(e)).collect(Collectors.toList());
        }*/

    }
    }

