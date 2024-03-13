package za.co.bbd.beanquizcli;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import za.co.bbd.beanquizcli.userservice.UserService;

public class UserServiceTest {

    // @Mock
    // private Map<String, String> users;

    // @InjectMocks
    // private UserService userService;

    // public void setUp() {
    //     MockitoAnnotations.initMocks(this);
    // }

    // @Test
    // public void testRegisterUser() {
    //     // Given
    //     String username = "testUser";
    //     String password = "testPassword";

    //     // When
    //     userService.registerUser(username, password);

    //     // Then
    //     Mockito.verify(users).put(username, password);
    // }

    // @Test
    // public void testAuthenticateUser() {
    //     // Given
    //     String username = "testUser";
    //     String password = "testPassword";
    //     Mockito.when(users.containsKey(username)).thenReturn(true);
    //     Mockito.when(users.get(username)).thenReturn(password);

    //     // When
    //     boolean authenticated = userService.authenticateUser(username, password);

    //     // Then
    //     assertTrue(authenticated);
    // }
}

