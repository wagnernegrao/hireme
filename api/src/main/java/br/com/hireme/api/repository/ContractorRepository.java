package br.com.hireme.api.repository;

import br.com.hireme.api.domain.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}
