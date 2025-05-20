import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    Divide div = new Divide();
    @Test
    public void testDiv(){
        assertThrows(ArithmeticException.class,() -> {
            int result = 10/0;
        });
    }
}