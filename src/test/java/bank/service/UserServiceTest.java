// package bank.service;

// import bank.domain.User;
// import bank.repository.UserRepository;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;
// import java.util.Optional;
// import java.util.List;
// import java.util.Arrays;

// public class UserServiceTest {

//     @Test
//     public void testCreateUser() {
//         UserRepository repo = mock(UserRepository.class);
//         UserService service = new UserServiceImpl(repo);

//         User user = new User(1L, "John Doe", "john@example.com");
//         when(repo.save(user)).thenReturn(user);

//         User created = service.createUser(user);
//         assertEquals("John Doe", created.getName());
//     }

//     @Test
//     public void testGetUser() {
//         UserRepository repo = mock(UserRepository.class);
//         UserService service = new UserServiceImpl(repo);

//         User user = new User(1L, "Jane Doe", "jane@example.com");
//         when(repo.findById(1L)).thenReturn(Optional.of(user));

//         User found = service.getUser(1L);
//         assertNotNull(found);
//         assertEquals("Jane Doe", found.getName());
//     }

//     @Test
//     public void testGetAllUsers() {
//         UserRepository repo = mock(UserRepository.class);
//         UserService service = new UserServiceImpl(repo);

//         List<User> users = Arrays.asList(new User(1L, "John", "a@b.com"), new User(2L, "Jane", "b@c.com"));
//         when(repo.findAll()).thenReturn(users);

//         List<User> result = service.getAllUsers();
//         assertEquals(2, result.size());
//     }
// }


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
        UserService service = new UserServiceImpl(repo); // Constructor injection

        User user = new User();
        user.setId(1L);
        user.setUsername("John Doe");
        user.setEmail("john@example.com");

        when(repo.save(user)).thenReturn(user);

        User created = service.createUser(user);
        assertEquals("John Doe", created.getUsername());
        assertEquals("john@example.com", created.getEmail());
    }

    @Test
    public void testGetUser() {
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserServiceImpl(repo);

        User user = new User();
        user.setId(1L);
        user.setUsername("Jane Doe");
        user.setEmail("jane@example.com");

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        User found = service.getUserById(1L);
        assertNotNull(found);
        assertEquals("Jane Doe", found.getUsername());
    }

    @Test
    public void testGetAllUsers() {
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserServiceImpl(repo);

        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("John");
        user1.setEmail("a@b.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("Jane");
        user2.setEmail("b@c.com");

        List<User> users = Arrays.asList(user1, user2);
        when(repo.findAll()).thenReturn(users);

        List<User> result = service.getAllUsers();
        assertEquals(2, result.size());
        assertEquals("Jane", result.get(1).getUsername());
    }
}
