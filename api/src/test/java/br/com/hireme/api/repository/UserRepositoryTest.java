package br.com.hireme.api.repository;

import br.com.hireme.api.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for User repository")
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Find by email then successful")
    void shouldReturnUserWhenFindEmail() {
        Optional<User> userSaved = this.userRepository.findByEmail("user@gmail.com");

        Assertions.assertThat(userSaved).isNotEmpty();

        Assertions.assertThat(userSaved.get()).isNotNull();

        Assertions.assertThat(userSaved.get().getEmail()).isNotNull();

        Assertions.assertThat(userSaved.get().getEmail()).isEqualTo("user@gmail.com");
    }

    @Test
    @DisplayName("Find by email not existing then not successful")
    void shouldReturnEmptyWhenFindEmail() {
        Optional<User> userSaved = this.userRepository.findByEmail("alone@gmail.com");

        Assertions.assertThat(userSaved).isEmpty();
    }

    @Test
    @DisplayName("Save a user then successful")
    void shouldReturnUserWhenSave() {
        User user = createUser();
        User userCreated = this.userRepository.save(user);

        Assertions.assertThat(userCreated).isNotNull();

        Assertions.assertThat(userCreated.getId()).isNotNull();

        Assertions.assertThat(userCreated.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    @DisplayName("Find by id then successful")
    void shouldReturnUserWhenFindById() {
        Optional<User> user = this.userRepository.findById(1L);

        Assertions.assertThat(user).isNotEmpty();

        Assertions.assertThat(user.get()).isNotNull();

        Assertions.assertThat(user.get().getEmail()).isEqualTo("user@gmail.com");
    }

    @Test
    @DisplayName("Find by id not exists then not successful")
    void shouldReturnEmptyWhenFindById() {
        Optional<User> user = this.userRepository.findById(999L);

        Assertions.assertThat(user).isEmpty();
    }

    @Test
    @DisplayName("Update user then successful")
    void shouldUpdateWhenUpdate() {
        String newEmail = "newUser@gmail.com";
        Optional<User> user = this.userRepository.findById(1L);
        user.get().setEmail(newEmail);
        User userUpdated = this.userRepository.save(user.get());

        Assertions.assertThat(userUpdated).isNotNull();

        Assertions.assertThat(userUpdated.getEmail()).isEqualTo(newEmail);
    }

    @Test
    @DisplayName("Delete user then successful")
    void shouldDeleteWhenSuccessful() {
        User user = new User("userToDelete@gmail.com", "12345",
                "photo".getBytes(), true, false);
        User userSaved = this.userRepository.save(user);
        this.userRepository.delete(userSaved);

        Optional<User> userByEmail = this.userRepository.findByEmail("userToDelete@gmail.com");

        Assertions.assertThat(userByEmail).isEmpty();
    }

    private User createUser() {
        return new User("user@gmail.com", "12345",
                "photo".getBytes(), true, false);
    }
}