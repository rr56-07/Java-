import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    @Test
    public void isFormatCrtTest(){
        assertEquals("30-04-2004",DateFormatter.formatDate("2004-04-30"));
    }

}