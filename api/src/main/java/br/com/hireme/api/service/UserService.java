package br.com.hireme.api.service;

import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.dto.UserDto;

import java.util.List;

public interface UserService {
    /*
     * Find all users
     * */
    List<UserDto> findAll();

    /*
    * Find the user using ID, if this use not found is
    * return Not Found Exception.
    * */
    User findOne(Long id);

    /*
    * Save a user, but find if user already exists,
    * if find a user then return Not Accepted
    * if not found then create a user.
    * */
    User save(User user);

}
