package br.com.hireme.api.service.dto;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;

public class ContractorDto {

    private Long id;
    private String name;
    private String email;
    private byte[] photo;
    private Long cnpj;
    private String address;

    public ContractorDto(User user, Contractor contractor) {
        this.id = contractor.getId();
        this.name = contractor.getName();
        this.email = user.getEmail();
        this.photo = user.getPhoto();
        this.cnpj = contractor.getCnpj();
        this.address = contractor.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static ContractorDto toDto(User user, Contractor contractor) {
        return new ContractorDto(user, contractor);
    }
}
