package br.com.hireme.api.service.dto;

import br.com.hireme.api.domain.User;

import javax.persistence.Column;

public class CreateContractorDto {
    private User userId;
    private String name;
    private Long cnpj;
    private String address;

    public CreateContractorDto(User userId, String name, Long cnpj, String address) {
        this.userId = userId;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
