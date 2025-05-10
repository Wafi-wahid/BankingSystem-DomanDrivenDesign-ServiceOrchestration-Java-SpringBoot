package bank.service;

import bank.domain.User;
import bank.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("Test");
        user.setEmail("test@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);
        assertEquals("Test", result.getUsername());
        verify(userRepository).save(user);
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setUsername("John");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);
        assertEquals("John", result.getUsername());
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdateUser() {
        User existing = new User();
        existing.setId(1L);
        existing.setUsername("Old");
        existing.setEmail("old@example.com");

        User updated = new User();
        updated.setUsername("New");
        updated.setEmail("new@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(userRepository.save(existing)).thenReturn(existing);

        User result = userService.updateUser(1L, updated);
        assertEquals("New", result.getUsername());
        assertEquals("new@example.com", result.getEmail());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);
        userService.deleteUser(1L);
        verify(userRepository).deleteById(1L);
    }
}
