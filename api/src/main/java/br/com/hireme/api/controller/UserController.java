package br.com.hireme.api.controller;

import br.com.hireme.api.domain.User;
import br.com.hireme.api.repository.ContractorRepository;
import br.com.hireme.api.repository.UserRepository;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.UserContractorDto;
import br.com.hireme.api.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // usado para apresetar log
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUser() {
        log.debug("REST request to all users");
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(UserDto.toDto(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserContractorDto> findByUserId(@PathVariable Long id) {
        log.debug("REST request to id: {}", id);
        UserContractorDto user = userService.findOne(id);
        return ResponseEntity.ok().body(user);
    }
}
