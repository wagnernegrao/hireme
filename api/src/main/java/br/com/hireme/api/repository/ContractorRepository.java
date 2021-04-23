package br.com.hireme.api.repository;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.service.dto.ContractorCompleteDto;
import br.com.hireme.api.service.projections.ContractorProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractorRepository extends PagingAndSortingRepository<Contractor, Long> {

//    @Query(value = "SELECT NEW br.com.hireme.api.service.dto.ContractorCompleteDto(c.id, c.name, u.photo, u.email, c.cnpj, c.address) " +
//            "FROM Contractor c, User u WHERE c.userId = u.id AND c.userId = :pId")
//    Optional<ContractorCompleteDto> contractorComplete(@Param("pId") int id);

    @Query(value = "SELECT c.id, c.nome, u.foto, u.email, c.cnpj, c.endereco " +
            "FROM contratante c INNER JOIN usuario u on c.usuario_id = u.id WHERE c.id = :pId", nativeQuery = true)
    Optional<ContractorProjection> contractorComplete(@Param("pId") Long id);

    Optional<Contractor> findByCnpj(String cnpj);
}
