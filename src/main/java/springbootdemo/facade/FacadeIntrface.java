package springbootdemo.facade;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import springbootdemo.model.User;

interface FacadeInterface {
    //это интерфейс для фасада

    String findAll(Model model);

    String createUserForm(User user);

    String createUser(User user);

    String deleteUser(@PathVariable("id") Long id);

    String updateUserForm(@PathVariable("id") Long id, Model model);

    String updateUser(User user);

}

