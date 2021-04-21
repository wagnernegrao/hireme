package br.com.hireme.api.service.dto;

import br.com.hireme.api.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Long id;
    private String email;
    private byte[] photo;
    private boolean isContractor;
    private boolean isServiceProvider;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.photo = user.getPhoto();
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public static UserDto toDto(User user) {
        return new UserDto(user);
    }
}
