package br.com.hireme.api.repository;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.domain.User;
import br.com.hireme.api.util.ContractorCreator;
import br.com.hireme.api.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("Test for contractor repository")
class ContractorRepositoryTest {
    UserCreator userCreator = new UserCreator();
    ContractorCreator contractorCreator = new ContractorCreator();

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Find by id then return contractor")
    void shouldReturnContractorWhenFindById() {
        Optional<Contractor> contractor = this.contractorRepository.findById(1L);

        Assertions.assertThat(contractor).isNotEmpty();

        Assertions.assertThat(contractor.get()).isNotNull();

        Assertions.assertThat(contractor.get().getName()).isEqualTo("user");
    }

    @Test
    @DisplayName("Find by id not exist then return empty")
    void shouldReturnEmptyWhenFindById() {
        Optional<Contractor> contractor = this.contractorRepository.findById(99L);

        Assertions.assertThat(contractor).isEmpty();
    }

    @Test
    @DisplayName("Find by cnpj then return contractor")
    void shouldReturnContractorWhenFindByCnpj() {
        Optional<Contractor> contractor = this.contractorRepository.findByCnpj("00.000.000/0001-00");

        Assertions.assertThat(contractor).isNotEmpty();

        Assertions.assertThat(contractor.get()).isNotNull();

        Assertions.assertThat(contractor.get().getCnpj()).isEqualTo("00.000.000/0001-00");
    }

    @Test
    @DisplayName("Find by cnpj not exists then return empty")
    void shouldReturnEmptyWhenFindByCnpj() {
        Optional<Contractor> contractor = this.contractorRepository.findByCnpj("100.000.000/0001-00");

        Assertions.assertThat(contractor).isEmpty();
    }

    @Test
    @DisplayName("Save a contractor then return successful")
    void shouldReturnContractorWhenSave() {
        User user = userCreator.createValidUser();
        User userSaved = this.userRepository.save(user);
        Contractor contractor = contractorCreator.createValidContractor(userSaved);
        Contractor contractorSaved = this.contractorRepository.save(contractor);

        Assertions.assertThat(contractorSaved).isNotNull();

        Assertions.assertThat(contractorSaved.getId()).isNotNull();

        Assertions.assertThat(contractorSaved.getCnpj()).isEqualTo(contractor.getCnpj());
    }

    @Test
    @DisplayName("Update a contractor then return successful")
    void shouldReturnContractorWhenUpdate() {
        String newName = "new name contractor";
        Optional<Contractor> contractor = contractorRepository.findById(1L);
        contractor.get().setName(newName);

        Contractor contractorUpdated = contractorRepository.save(contractor.get());

        Assertions.assertThat(contractorUpdated).isNotNull();

        Assertions.assertThat(contractorUpdated.getId()).isNotNull();

        Assertions.assertThat(contractorUpdated.getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("Delete a contractor then return successful")
    void shouldReturnSuccessfulWhenDelete() {
        contractorRepository.deleteById(1L);

        Optional<Contractor> contractor = contractorRepository.findById(1L);

        Assertions.assertThat(contractor).isEmpty();
    }
}