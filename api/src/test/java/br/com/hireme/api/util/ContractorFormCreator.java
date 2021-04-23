package br.com.hireme.api.util;

import br.com.hireme.api.service.dto.form.ContractorForm;

public class ContractorFormCreator {

    public static ContractorForm createContractorForm() {
        return new ContractorForm("userValid.@email.com",
                "12345",
                "photo",
                "Contractor valid",
                "110.000.000/0001-00",
                "Address");
    }
}
