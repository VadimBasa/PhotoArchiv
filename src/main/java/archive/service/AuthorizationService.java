package archive.service;

import org.springframework.stereotype.Service;
import archive.exception.InvalidCredentials;
import archive.exception.UnauthorizedUser;
import archive.model.Authorities;
import archive.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AuthorizationService implements AuthorizationServiceInterface {
   // UserRepository userRepository;

    //public AuthorizationService(UserRepository userRepository) {
   //     this.userRepository = userRepository;
    //}


    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("1111")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("manager") && password.equals("2222")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("user") && password.equals("3333")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
