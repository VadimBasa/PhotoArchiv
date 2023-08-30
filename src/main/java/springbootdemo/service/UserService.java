package springbootdemo.service;

import org.springframework.stereotype.Service;
import springbootdemo.model.User;
import springbootdemo.repository.UserRepository;
import java.util.List;

@Service
public class UserService implements ServiceUserInterface {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {//, User user
        this.userRepository = userRepository;

    }
    public User saveUser(User user) {
        System.out.println("I am create user" + user.getFirstName());
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("User with id %d not found", id))
                );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }



    public User deleteById(Long id) {

        userRepository.deleteById(id);
        return null;
    }
}

