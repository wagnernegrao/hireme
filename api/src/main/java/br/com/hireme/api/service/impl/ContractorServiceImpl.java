package br.com.hireme.api.service.impl;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.handler.exception.BadRequestException;
import br.com.hireme.api.handler.exception.NoContentException;
import br.com.hireme.api.repository.ContractorRepository;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.form.ContractorForm;
import br.com.hireme.api.service.projections.ContractorProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    ContractorRepository contractorRepository;

    @Autowired
    UserService userService;

    @Override
    public Page<Contractor> findAll(Pageable pageable) {
        Page<Contractor> page = contractorRepository.findAll(pageable);

        if (page.getNumberOfElements() == 0) {
            throw new NoContentException("The search returned no element");
        }

        return page;
    }

    @Override
    public ContractorProjection save(ContractorForm form) {
        User user = userService.save(form.toUser());
        Contractor contractor = form.toContractor(user);

        Optional<Contractor> contractorCnpj = contractorRepository.findByCnpj(contractor.getCnpj());

        if (contractorCnpj.isPresent()) {
            throw new BadRequestException("Not Acceptable, cnpj: " + contractorCnpj.get().getCnpj() + " in use");
        }

        Long id = contractorRepository.save(contractor).getId();

        Optional<ContractorProjection> complete = contractorRepository.contractorComplete(id);

        return complete.get();
    }
}
