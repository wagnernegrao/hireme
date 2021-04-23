package br.com.hireme.api.controller;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.ContractorCompleteDto;
import br.com.hireme.api.service.dto.form.ContractorForm;
import br.com.hireme.api.service.projections.ContractorProjection;
import com.fasterxml.jackson.core.TreeNode;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/api/contractors")
public class ContractorController {
    // usado para apresetar log
    private Logger log = LoggerFactory.getLogger(ContractorController.class);

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "List all contractors paginated", description = "The default size is 20, use the parameter " +
            "size to change the default value", tags = {"contractor"})
    public ResponseEntity<Page<Contractor>> listAll(@ParameterObject Pageable pageable) {
        log.debug("REST request to all users");

        return ResponseEntity.ok().body(contractorService.findAll(pageable));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Create a contractor", description = "Receive a form with data of user and contractor.",
            tags = {"contractor"})
    public ResponseEntity<ContractorProjection> create(@RequestBody ContractorForm form) {
        log.debug("REST request to userForm: {}", form);

        ContractorProjection contractor = contractorService.save(form);
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        URI uri = builder.path("/api/contractors/{id}").buildAndExpand(contractor.getId()).toUri();

//        return ResponseEntity.ok().body(contractor);
        return ResponseEntity.created(uri).body(contractor);
    }
}
