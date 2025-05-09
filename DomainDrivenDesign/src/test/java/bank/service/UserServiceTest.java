package bank.service;

import bank.domain.User;
import bank.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testCreateUser() {
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserServiceImpl(repo);

        User user = new User(null, "John Doe", "john@example.com");
        User saved = new User(1L, "John Doe", "john@example.com");

        when(repo.save(user)).thenReturn(saved);

        User created = service.createUser(user);
        assertEquals("John Doe", created.getUsername());
        assertEquals("john@example.com", created.getEmail());
    }

    @Test
    public void testGetUser() {
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserServiceImpl(repo);

        User user = new User(1L, "Jane Doe", "jane@example.com");
        when(repo.findById(1L)).thenReturn(Optional.of(user));

        User found = service.getUserById(1L);
        assertNotNull(found);
        assertEquals("Jane Doe", found.getUsername());
    }

    @Test
    public void testGetAllUsers() {
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserServiceImpl(repo);

        List<User> users = Arrays.asList(
            new User(1L, "John", "a@b.com"),
            new User(2L, "Jane", "b@c.com")
        );

        when(repo.findAll()).thenReturn(users);

        List<User> result = service.getAllUsers();
        assertEquals(2, result.size());
        assertEquals("Jane", result.get(1).getUsername());
    }
}
