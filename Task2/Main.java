import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Weather Data Fetcher ===");
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        
        try {
            WeatherData data = WeatherService.getWeatherData(city);
            System.out.println("\n" + data);
        } catch (IOException e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
            System.err.println("Please check your internet connection or API key");
        } catch (JSONException e) {
            System.err.println("Error parsing weather data: " + e.getMessage());
            System.err.println("City not found or invalid API response");
        } finally {
            scanner.close();
        }
    }
}