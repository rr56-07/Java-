public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celcius){
        return (celcius*9)/5+32;
    }
    public static double fahrenheitToCelcius(double fahrenheit){
        return ((fahrenheit - 32) *5)/9;
    }
}
