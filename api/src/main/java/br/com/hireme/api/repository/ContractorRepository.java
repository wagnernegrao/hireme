package br.com.hireme.api.repository;

import br.com.hireme.api.domain.Contractor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ContractorRepository extends PagingAndSortingRepository<Contractor, Long> {

//    @Query(value = "SELECT NEW br.com.hireme.api.service.dto.FullContractorDto(c.id, c.name, u.photo, u.email, c.cnpj, c.address) " +
//            "FROM Contractor c INNER JOIN User u ON c.userId = u.id")
//    Page<FullContractorDto> allContractors(Pageable pageable);

    Optional<Contractor> findByCnpj(String cnpj);
}
