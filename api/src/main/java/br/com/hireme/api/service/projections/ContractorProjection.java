package br.com.hireme.api.service.projections;

import org.springframework.beans.factory.annotation.Value;

public interface ContractorProjection {

    Long getId();
    @Value("#{target.nome}")
    String getName();
    @Value("#{target.foto}")
    Byte[] getPhoto();
    String getEmail();
    String getCnpj();
    @Value("#{target.endereco}")
    String getAddress();
}
