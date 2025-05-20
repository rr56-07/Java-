import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils str = new StringUtils();
    @Test
    public void testReverse(){
        assertEquals("nahom",str.revString("mohan"));
    }

    @Test
    public void isPalindromeTest(){
        assertTrue(str.palindrome("malayalam"));
    }

    @Test
    public void toUpperTest(){
        assertEquals("MOHAN",str.toUpper("mohan"));
    }
}