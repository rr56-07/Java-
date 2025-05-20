import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void isValisPasswordtest(){
        assertTrue(PasswordValidator.isValid("Password1"));
    }

    @Test
    public void isNotValisPasswordtest(){
        assertFalse(PasswordValidator.isValid("Psword1"));
    }

}