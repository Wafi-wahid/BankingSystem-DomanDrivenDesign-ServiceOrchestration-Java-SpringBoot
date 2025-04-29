package bank.service;

import bank.domain.User;
import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
