package br.com.hireme.api.controller;

import br.com.hireme.api.domain.Contractor;
import br.com.hireme.api.service.ContractorService;
import br.com.hireme.api.service.UserService;
import br.com.hireme.api.service.projections.ContractorProjection;
import br.com.hireme.api.util.ContractorCreator;
import br.com.hireme.api.util.ContractorFormCreator;
import br.com.hireme.api.util.ContractorProjectionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@ExtendWith(SpringExtension.class)
class ContractorControllerTest {

    ContractorCreator contractorCreator = new ContractorCreator();

    @InjectMocks
    private ContractorController contractorController;

    @Mock
    private ContractorService contractorServiceMock;
    @Mock
    private UserService userServiceMock;

    @Mock
    private UriComponentsBuilder uri;

    @BeforeEach
    void setUp() {
        PageImpl<Contractor> contractorPage = new PageImpl<>(List.of(contractorCreator.createContractor()));
        BDDMockito.when(contractorServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(contractorPage);

//        BDDMockito.when(contractorServiceMock.findById(ArgumentMatchers.anyLong()))
//                .thenReturn(contractorCreator.createContractor());

        BDDMockito.when(contractorServiceMock.save(ArgumentMatchers.any()))
                .thenReturn(ContractorProjectionCreator.createContractorProjection());
    }

    @Test
    @DisplayName("Returns list of anime inside page object when successful")
    void shouldReturnListOfContractorsInsidePageObjectWhenFindAll() {
        String expectedName = contractorCreator.createContractor().getName();
        Page<Contractor> contractorPage = contractorController.listAll(null).getBody();

        Assertions.assertThat(contractorPage).isNotNull();

        Assertions.assertThat(contractorPage.toList()).isNotEmpty().hasSize(1);

        Assertions.assertThat(contractorPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

//    @Test
//    @DisplayName("Find by id returns a contractor when successful")
//    void findById_ReturnsContractor_WhenSuccessful() {
//        String expectedName = contractorCreator.createContractor().getName();
//        Optional<Contractor> contractor = contractorController.findById(1L);
//
//        Assertions.assertThat(contractor).isNotEmpty();
//
//        Assertions.assertThat(contractor.get().getName()).isNotNull();
//
//        Assertions.assertThat(contractor.get().getName()).isEqualTo(expectedName);
//    }

    @Test
    @DisplayName("Create returns a contractor when successful")
    void create_ReturnsContractor_WhenSuccessful() {
        String expectedName = ContractorProjectionCreator.createContractorProjection().getName();
        ContractorProjection contractor = contractorController.create(ContractorFormCreator.createContractorForm()).getBody();

        Assertions.assertThat(contractor).isNotNull();

        Assertions.assertThat(contractor.getId()).isNotNull();

        Assertions.assertThat(contractor.getName()).isEqualTo(expectedName);
    }
}