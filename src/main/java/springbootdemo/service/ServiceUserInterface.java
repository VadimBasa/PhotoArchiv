package springbootdemo.service;

import springbootdemo.model.User;

import java.util.List;

public interface ServiceUserInterface {
    User findById(Long id);
   //void findById(Long id);

    List<User> findAll();

   User saveUser();

    void deleteById(Long id);
}
