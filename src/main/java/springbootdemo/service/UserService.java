package springbootdemo.service;

import org.springframework.stereotype.Service;
import springbootdemo.model.User;
import springbootdemo.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements ServiceUserInterface {

    private UserRepository userRepository;

    //private User user;

    public UserService(UserRepository userRepository) {//, User user
        this.userRepository = userRepository;
       // this.user = user;
    }
    public User saveUser(User user) {
        //this.user = user;
        System.out.println("I am create user" + user.getFirstName());
        return userRepository.save(user);
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



    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

