package br.com.hireme.api.service.dto;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;

import java.util.Arrays;
import java.util.Objects;

public class ContractorCompleteDto {

    private Long id;
    private String name;
    private byte[] photo;
    private String email;
    private String cnpj;
    private String address;

    public ContractorCompleteDto(){}

    public ContractorCompleteDto(Long id, String name, byte[] photo, String email, String cnpj, String address) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.cnpj = cnpj;
        this.address = address;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorCompleteDto that = (ContractorCompleteDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Arrays.equals(photo, that.photo) && Objects.equals(email, that.email) && Objects.equals(cnpj, that.cnpj) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, email, cnpj, address);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    public static ContractorCompleteDto toDto(User u, Contractor c) {
        return new ContractorCompleteDto(c.getId(), c.getName(), u.getPhoto(), u.getEmail(), c.getCnpj(), c.getAddress());
    }
}
