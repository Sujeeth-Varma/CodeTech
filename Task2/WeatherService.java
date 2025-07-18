import java.net.*;
import java.io.*;
import org.json.*;

public class WeatherService {
    private static final String API_KEY = "YOUR_API_KEY"; // Get from https://openweathermap.org/api
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static WeatherData getWeatherData(String city) throws IOException {
        String urlString = String.format(API_URL, URLEncoder.encode(city, "UTF-8"), API_KEY);
        URL url = new URL(urlString);
        
        try (InputStream input = url.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            return parseWeatherData(response.toString());
        }
    }
    
    private static WeatherData parseWeatherData(String jsonResponse) {
        JSONObject obj = new JSONObject(jsonResponse);
        
        String city = obj.getString("name");
        String country = obj.getJSONObject("sys").getString("country");
        double temp = obj.getJSONObject("main").getDouble("temp");
        double feelsLike = obj.getJSONObject("main").getDouble("feels_like");
        int humidity = obj.getJSONObject("main").getInt("humidity");
        String condition = obj.getJSONArray("weather")
                            .getJSONObject(0)
                            .getString("main");
        
        return new WeatherData(city, country, temp, feelsLike, humidity, condition);
    }
}