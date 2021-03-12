package br.com.hireme.api.service;

import br.com.hireme.api.service.dto.UserContractorDto;
import br.com.hireme.api.service.dto.UserDto;

import java.util.Optional;

public interface UserService {

    UserContractorDto findOne(Long id);
}
