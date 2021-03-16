package br.com.hireme.api.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prestador_servico")
public class ServiceProvider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "usuario_id")
    private User userId;
    @Column(name = "primeiro_nome")
    private String firstName;
    @Column(name = "ultimo_nome")
    private String lastName;
    @Column(name = "numero_telefone")
    private String phoneNumber;
    @Column(name = "habilidade")
    private String ability;

    public ServiceProvider(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
