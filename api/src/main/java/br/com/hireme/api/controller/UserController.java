package br.com.hireme.api.controller;

import br.com.hireme.api.model.User;
import br.com.hireme.api.repository.UserRepository;
import br.com.hireme.api.service.dto.UserDto;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // usado para apresetar log
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUser() {
        log.debug("REST request to all users");
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(UserDto.toDto(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByUserId(@PathVariable Long id) {
        log.debug("REST request to id: {}", id);
        Optional<User> user = userRepository.findById(id);

        return user
                .map(value -> ResponseEntity
                        .ok()
                        .body(UserDto.toDto(value)))
                        .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
