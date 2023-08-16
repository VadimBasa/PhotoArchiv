package springbootdemo.service;

import springbootdemo.model.Authorities;

import java.util.List;

public interface AuthorizationServiceInterface {
    //это интерфейс для сервиса авторизации
    List<Authorities> getAuthorities(String user, String password);

}

