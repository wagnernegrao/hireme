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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private User userId;
    @Column(name = "nome")
    private String name;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "endereco")
    private String address;

    public Contractor(){}
    public Contractor(User userId, String name, String cnpj, String address) {
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
    public String toString() {
        return "Contractor {" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", cnpj=" + cnpj +
                ", address='" + address + '\'' +
                '}';
    }
}
