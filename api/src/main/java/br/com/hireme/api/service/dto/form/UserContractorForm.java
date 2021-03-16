package br.com.hireme.api.service.dto.form;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.service.UserService;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserContractorForm {
    @NotEmpty
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @NotNull
    private String password;
    private String photo;
    @NotNull
    @NotEmpty
    private boolean isContractor;
    @NotNull
    @NotEmpty
    private boolean isServiceProvider;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @CNPJ
    private Long cnpj;
    @NotNull
    @NotEmpty
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public User toUser() {
        if (photo == null) {
            return new User(email, password, null, isContractor, isServiceProvider);
        }

        return new User(email, password, photo.getBytes(), isContractor, isServiceProvider);
    }

    public Contractor toContractor(UserService us, User u) {
        User user = us.findOne(u.getId());
        return new Contractor(user, name, cnpj, address);
    }
}
