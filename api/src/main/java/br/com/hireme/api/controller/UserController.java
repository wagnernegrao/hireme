package br.com.hireme.api.controller;

import br.com.hireme.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
}
