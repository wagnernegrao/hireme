package br.com.hireme.api.controller;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.UserContractorDto;
import br.com.hireme.api.service.dto.UserDto;
import br.com.hireme.api.service.dto.form.UserContractorForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/contractors")
public class UserController {

    // usado para apresetar log
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "List all contractors paginated", description = "The default size is 20, use the parameter" +
            "size to change the default value", tags = {"Contractor"})
    public ResponseEntity<List<UserDto>> listAll(@ParameterObject Pageable pageable) {
        log.debug("REST request to all users");
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserContractorDto> create(@Valid @RequestBody UserContractorForm userForm, UriComponentsBuilder builder) {
        log.debug("REST request to userForm: {}", userForm);
        User user = userService.save(userForm.toUser());
        Contractor contractor = contractorService.save(userForm.toContractor(userService, user));
        URI uri = builder.path("/api/users/{id}").buildAndExpand(contractor.getId()).toUri();

        return ResponseEntity.ok().body(new UserContractorDto(user, contractor));
    }
}
