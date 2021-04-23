package br.com.hireme.api.util;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.dto.ContractorCompleteDto;

public class ContractorCreator {

    public ContractorCompleteDto createContractorFiltered() {
        ContractorCompleteDto contractor = new ContractorCompleteDto(99L, "contractor", "photo".getBytes(), "contractor@gmail.com", "00.000.000/0001-00", "address");
        return contractor;
    }

    public Contractor createValidContractor(User user) {
        return new Contractor(user,
                "Contractor valid",
                "110.000.000/0001-00",
                "Address");
    }

    public Contractor createContractor() {
        User user = new User("userValid.@email.com",
                "12345",
                "photo".getBytes());

        return new Contractor(user,
                "Contractor valid",
                "110.000.000/0001-00",
                "Address");
    }
}
