package br.com.hireme.api.controller;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.UserContractorDto;
import br.com.hireme.api.service.dto.UserDto;
import br.com.hireme.api.service.dto.form.UserContractorForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // usado para apresetar log
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUser() {
        log.debug("REST request to all users");
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserContractorDto> createUser(@Valid @RequestBody UserContractorForm userForm, UriComponentsBuilder builder) {
        log.debug("REST request to userForm: {}", userForm);
        User user = userService.save(userForm.toUser());
        Contractor contractor = contractorService.save(userForm.toContractor(userService, user));
        URI uri = builder.path("/api/users/{id}").buildAndExpand(contractor.getId()).toUri();

        return ResponseEntity.ok().body(new UserContractorDto(user, contractor));
    }
}
