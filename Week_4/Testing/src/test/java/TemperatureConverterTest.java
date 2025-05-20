import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    @Test
    public void testingConverter(){
        assertEquals(77,TemperatureConverter.celsiusToFahrenheit(25));
    }

    @Test
    public void testingConverterFtoC(){
        assertEquals(25,TemperatureConverter.fahrenheitToCelcius(77));
    }

}