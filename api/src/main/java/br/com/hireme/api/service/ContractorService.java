package br.com.hireme.api.service;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.handler.exception.NotAcceptableException;
import br.com.hireme.api.service.dto.form.ContractorForm;
import br.com.hireme.api.service.projections.ContractorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractorService {
    /*
     * Return all contractors using fields of the user and contractor,
     * if the search returns none element, then return "No Content"
     * */
    Page<Contractor> findAll(Pageable pageable);

    /*
     * Receive the form then create a user, but verify if exists,
     * and after create a contractor, but verify if exists.
     * If exists in some case that already exists, then return Not Accepted.
     * */
    ContractorProjection save(ContractorForm form) throws NotAcceptableException;
}
