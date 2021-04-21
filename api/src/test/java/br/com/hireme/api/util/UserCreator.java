package br.com.hireme.api.util;

import br.com.hireme.api.domain.User;

public class UserCreator {

    public User createValidUser() {
        return new User("userValid.@email.com",
                "12345",
                "photo".getBytes()
        );
    }
}
