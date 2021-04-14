package br.com.hireme.api.service.impl;

import br.com.hireme.api.domain.User;
import br.com.hireme.api.handler.exception.BadRequestException;
import br.com.hireme.api.handler.exception.NotAcceptableException;
import br.com.hireme.api.handler.exception.NotFoundException;
import br.com.hireme.api.repository.ContractorRepository;
import br.com.hireme.api.repository.UserRepository;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContractorRepository contractorRepository;


    @Override
    @Transactional
    public User findOne(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Not found by id: " + id));
    }

    @Override
    public User save(User user) {
        Optional<User> userEmail = userRepository.findByEmail(user.getEmail());

        if (userEmail.isPresent()){
            throw new BadRequestException("Not Acceptable, email: " + userEmail.get().getEmail() + " in use");
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail() {
        return Optional.empty();
    }

    @Override
    public List<UserDto> findAll() {
        List<User> user = (List<User>) userRepository.findAll();
        return user.stream().map(UserDto::toDto).collect(Collectors.toList());
    }

}
