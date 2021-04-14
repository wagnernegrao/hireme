package br.com.hireme.api.service.dto;

import br.com.hireme.api.domain.User;

import javax.persistence.Column;

public class ContractorDto {
    private Long userId;
    private String name;
    private Long cnpj;
    private String address;

    public ContractorDto(Long userId, String name, Long cnpj, String address) {
        this.userId = userId;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
