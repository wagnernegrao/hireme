package br.com.hireme.api.util;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.dto.FullContractorDto;

public class ContractorCreator {

    public FullContractorDto createContractorFiltered() {
        FullContractorDto contractor = new FullContractorDto(99L, "contractor", "photo".getBytes(), "contractor@gmail.com", "00.000.000/0001-00", "address");
        return contractor;
    }

    public Contractor createValidContractor(User user) {
        return new Contractor(user,
                "Contractor valid",
                "110.000.000/0001-00",
                "Address");
    }
}
