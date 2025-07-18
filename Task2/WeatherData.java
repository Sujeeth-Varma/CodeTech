public class WeatherData {
    private String city;
    private String country;
    private double temperature;
    private double feelsLike;
    private int humidity;
    private String weatherCondition;
    
    public WeatherData(String city, String country, double temperature, 
                      double feelsLike, int humidity, String weatherCondition) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.weatherCondition = weatherCondition;
    }
    
    @Override
    public String toString() {
        return String.format(
            "┌─────────────────────────────────┐\n" +
            "│ %-15s Weather Report │\n" +
            "├─────────────────────────────────┤\n" +
            "│ City: %-25s │\n" +
            "│ Country: %-23s │\n" +
            "│ Temperature: %-18.1f°C │\n" +
            "│ Feels Like: %-19.1f°C │\n" +
            "│ Humidity: %-21d%% │\n" +
            "│ Condition: %-20s │\n" +
            "└─────────────────────────────────┘",
            city, city, country, temperature, feelsLike, humidity, weatherCondition
        );
    }
}