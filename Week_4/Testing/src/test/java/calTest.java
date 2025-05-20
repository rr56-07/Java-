import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calTest {
    Cal calc = new Cal();

    @Test
    public void testAdd() {
        assertEquals(2, calc.add(2, 3));
        assertEquals(-1, calc.add(2, -3));
    }
    @Test
    public void testSubtract() {
        assertEquals(-1, calc.subtract(2, 3));
        assertEquals(5, calc.subtract(2, -3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(-6, calc.multiply(2, -3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calc.divide(6, 3));
        assertEquals(-2, calc.divide(6, -3));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(5, 0);
        });
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

}