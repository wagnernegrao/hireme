package br.com.hireme.api.service.impl;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.handler.exception.BadRequestException;
import br.com.hireme.api.handler.exception.NoContentException;
import br.com.hireme.api.handler.exception.NotAcceptableException;
import br.com.hireme.api.repository.ContractorRepository;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.dto.FullContractorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    ContractorRepository contractorRepository;

    @Override
    public Page<FullContractorDto> allContractors(Pageable pageable) {
        Page<FullContractorDto> page = contractorRepository.allContractors(pageable);

        if (page.getNumberOfElements() == 0) {
            throw new NoContentException("The search returned no element");
        }

        return page;
    }

    @Override
    public Contractor findOne(Long id) {
        return null;
    }


    @Override
    public Contractor save(Contractor contractor) {
        Optional<Contractor> contractorCnpj = contractorRepository.findByCnpj(contractor.getCnpj());

        if (contractorCnpj.isPresent()){
            throw new BadRequestException("Not Acceptable, cnpj: " + contractorCnpj.get().getCnpj() + " in use");
        }
        return contractorRepository.save(contractor);
    }
}
