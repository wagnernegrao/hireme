package br.com.hireme.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "contractor")
    private boolean isContractor;
    @Column(name = "service_provider")
    private boolean isServiceProvider;

    public User() {
    }

    public User(String email, String password, byte[] photo, boolean isContractor, boolean isServiceProvider) {
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.isContractor = isContractor;
        this.isServiceProvider = isServiceProvider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isContractor == user.isContractor && isServiceProvider == user.isServiceProvider && Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Arrays.equals(photo, user.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, email, password, isContractor, isServiceProvider);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
