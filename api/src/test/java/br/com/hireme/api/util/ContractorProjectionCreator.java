package br.com.hireme.api.util;

import br.com.hireme.api.service.projections.ContractorProjection;

public class ContractorProjectionCreator implements ContractorProjection {

    private Long id;
    private String name;
    private String photo;
    private String email;
    private String cnpj;
    private String address;

    public ContractorProjectionCreator(Long id, String name, String photo, String email, String cnpj, String address) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.cnpj = cnpj;
        this.address = address;
    }

    public static ContractorProjectionCreator createContractorProjection() {
        return new ContractorProjectionCreator(1L,
                "Contractor",
                null,
                "contractor@gmail.com",
                "110.000.000/0001-00",
                "localhost");
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Byte[] getPhoto() {
        return new Byte[0];
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getCnpj() {
        return this.cnpj;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
