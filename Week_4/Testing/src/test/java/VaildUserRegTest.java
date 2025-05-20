import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaildUserRegTest {
    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() ->
                UserRegistration.registerUser("mohanraj", "mohan@example.com", "StrongPass1"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("", "test@example.com", "StrongPass1"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }
}