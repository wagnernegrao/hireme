package br.com.hireme.api.service.dto.form;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.handler.exception.BadRequestException;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.UserService;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class ContractorForm {
    @NotEmpty(message = "This field no can be empty")
    @NotNull
    private String email;
    @NotEmpty(message = "This field no can be empty")
    @NotNull
    private String password;
    @NotEmpty(message = "This field no can be empty")
    @NotNull
    private boolean isContractor;
    private String photo;
    @NotEmpty(message = "This field no can be empty")
    @NotNull
    private boolean isServiceProvider;
    @NotEmpty(message = "This field no can be empty")
    @NotNull
    private String name;
    @NotNull
    @NotEmpty(message = "This field no can be empty")
    private String cnpj;
    @NotEmpty(message = "This field no can be empty")
    @NotNull
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isContractor() {
        return isContractor;
    }

    public void setContractor(boolean contractor) {
        isContractor = contractor;
    }

    public boolean isServiceProvider() {
        return isServiceProvider;
    }

    public void setServiceProvider(boolean serviceProvider) {
        isServiceProvider = serviceProvider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validateCnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


//    public void validate(ContractorService contractorService, UserService userService) {
//         userService.findByEmail();
//
//    }

    private void validateEmail(String email) {
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

        if (email.matches(regex)) {
//            this.setEmail(email);
            System.out.println("\n\n\n Passou");
        } else {
            throw new BadRequestException("The email is invalid.");
        }
    }

    private void validateCnpj(String cnpj) {
        String regex = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})";

        if (cnpj.matches(regex)) {
            System.out.println("\n\n\n Passou");
        } else {
            throw new BadRequestException("The CNPJ is invalid.");
        }
    }


    public User toUser() {
        if (photo == null) {
            return new User(email, password, null, isContractor, isServiceProvider);
        }

        return new User(email, password, photo.getBytes(), isContractor, isServiceProvider);
    }

    public Contractor toContractor(User user) {

        return new Contractor(user, this.name, this.cnpj, this.address);
    }
}
