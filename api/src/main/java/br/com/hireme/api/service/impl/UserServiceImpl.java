package br.com.hireme.api.service.impl;

import br.com.hireme.api.handler.exception.NotFoundException;
import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.repository.ContractorRepository;
import br.com.hireme.api.repository.UserRepository;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.UserContractorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContractorRepository contractorRepository;


    @Override
    @Transactional
    public UserContractorDto findOne(Long id) {
        Contractor contractor = contractorRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found by id: " + id));
        
        Optional<User> user = userRepository.findById(contractor.getUserId().getId());
        
        return UserContractorDto.toDto(user.get(), contractor);
       
    }
}
