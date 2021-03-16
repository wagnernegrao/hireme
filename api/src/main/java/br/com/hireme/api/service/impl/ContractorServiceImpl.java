package br.com.hireme.api.service.impl;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.repository.ContractorRepository;
import br.com.hireme.api.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    ContractorRepository contractorRepository;

    @Override
    public Contractor findOne(Long id) {
        return null;
    }

    @Override
    public Contractor save(Contractor contractor) {
       return contractorRepository.save(contractor);
    }
}
