package bank.repository;

import bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();
}
