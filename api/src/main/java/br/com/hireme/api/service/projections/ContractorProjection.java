package br.com.hireme.api.service.projections;

public interface ContractorProjection {

    Long getId();
    String getNome();
    Byte[] getFoto();
    String getEmail();
    String getCnpj();
    String getEndereco();
}
