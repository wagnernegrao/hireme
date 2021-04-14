package br.com.hireme.api.repository;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.service.dto.FullContractorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ContractorRepository extends PagingAndSortingRepository<Contractor, Long> {

//    @Query(value = "SELECT c.id, c.nome , u.foto, u.email, c.cnpj, c.endereco FROM contratante c INNER JOIN usuario u ON c.usuario_id = u.id", nativeQuery = true)
//    Page<FullContractorDto> allContractors(Pageable pageable);
    @Query(value = "SELECT NEW br.com.hireme.api.service.dto.FullContractorDto(c.id, c.name, u.photo, u.email, c.cnpj, c.address) " +
            "FROM Contractor c INNER JOIN User u ON c.userId = u.id")
    Page<FullContractorDto> allContractors(Pageable pageable);

    Optional<Contractor> findByCnpj(String cnpj);
}
