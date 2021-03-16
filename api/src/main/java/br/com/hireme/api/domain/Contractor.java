package br.com.hireme.api.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contratante")
public class Contractor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private User userId;
    @Column(name = "nome")
    private String name;
    @Column(name = "cnpj")
    private Long cnpj;
    @Column(name = "endereco")
    private String address;

    public Contractor(User userId, String name, Long cnpj, String address) {
        this.userId = userId;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
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
