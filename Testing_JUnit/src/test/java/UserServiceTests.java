import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testRegisterUserSuccessfully() {
        assertTrue(userService.registerUser("alice"));
        assertTrue(userService.isUserRegistered("alice"));
    }

    @Test
    void testRegisterDuplicateUser() {
        userService.registerUser("bob");
        assertFalse(userService.registerUser("bob"));
    }

    @Test
    void testRegisterNullUserThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser(null);
        });
        assertEquals("Username cannot be empty", ex.getMessage());
    }

    @Test
    void testRegisterBlankUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userService.registerUser("  "));
    }

    @Test
    void testClearUsers() {
        userService.registerUser("carol");
        userService.clearUsers();
        assertFalse(userService.isUserRegistered("carol"));
    }
}


