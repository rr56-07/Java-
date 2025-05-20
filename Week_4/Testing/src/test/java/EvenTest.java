import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;

class EvenTest {
    @ParameterizedTest
    @ValueSource(ints = {2,4,6})
    void testEven(int n){
        assertTrue(Even.isEven(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {7,9})
    void isNotEven(int n){
        assertFalse(Even.isEven(n));
    }
}