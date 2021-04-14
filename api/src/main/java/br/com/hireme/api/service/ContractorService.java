package br.com.hireme.api.service;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.handler.exception.NotAcceptableException;
import br.com.hireme.api.service.dto.FullContractorDto;
import br.com.hireme.api.service.projections.ContractorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractorService {
    /*
     * Return all contractors using fields of the user and contractor,
     * if the search returns none element, then return "No Content"
     * */
    Page<FullContractorDto> allContractors(Pageable pageable);

    Contractor findOne(Long id);

    /*
     * Save a contractor, but find if user already exists,
     * if find a user then return Not Accepted,
     * if not found then create a user.
     * */
    Contractor save(Contractor contractor) throws NotAcceptableException;
}
