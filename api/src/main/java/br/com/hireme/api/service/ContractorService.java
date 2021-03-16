package br.com.hireme.api.service;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;

public interface ContractorService {

    Contractor findOne(Long id);

    /*
     * Save a contractor
     * */
    Contractor save(Contractor contractor);
}
