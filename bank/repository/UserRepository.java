package bank.repository;

import bank.domain.User;
import java.util.Optional;
import java.util.List;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();
}
