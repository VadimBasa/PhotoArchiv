package springbootdemo.service;

import org.springframework.stereotype.Service;
import springbootdemo.model.User;
import springbootdemo.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements ServiceUserInterface {

    private UserRepository userRepository;

    private User user;

    public UserService() {
        this.userRepository = userRepository;
        this.user = user;
    }

   // public UserService() {

    //}

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("User with id %d not found", id))
                );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser() {
        //userRepository.save(user);
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

