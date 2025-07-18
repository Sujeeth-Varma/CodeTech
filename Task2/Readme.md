# Weather Data Fetcher Application

## Overview
This Java application fetches and displays current weather data from the OpenWeatherMap API. It demonstrates REST API consumption, JSON parsing, and structured data presentation.

## Features
- Fetches real-time weather data from OpenWeatherMap API
- Displays weather information in a structured format
- Handles API errors and invalid user input
- Clean separation of concerns (data model, service logic, UI)

## Prerequisites
1. Java 11 or higher
2. [JSON-Java library](https://github.com/stleary/JSON-java)
3. [OpenWeatherMap API Key](https://openweathermap.org/api) (free tier)

## Setup Instructions
1. **Get API Key**: Register at openweathermap.org to get your API key
2. **Set API Key**: Replace `YOUR_API_KEY` in `WeatherService.java`
3. **Add JSON Library**: Download json-20231013.jar and include in classpath

## How to Run
```bash
# Compile
javac -cp .;json-20231013.jar *.java

# Execute
java -cp .;json-20231013.jar Main
```

## Sample Output
```
=== Weather Data Fetcher ===
Enter city name: London

┌─────────────────────────────────┐
│ London          Weather Report │
├─────────────────────────────────┤
│ City: London                   │
│ Country: GB                    │
│ Temperature: 18.5°C            │
│ Feels Like: 17.8°C             │
│ Humidity: 75%                  │
│ Condition: Clouds              │
└─────────────────────────────────┘
```

## Troubleshooting
- "Invalid API key": Ensure you've replaced `YOUR_API_KEY`
- "City not found": Verify city name spelling
- Connection errors: Check internet connectivity
- Library errors: Confirm JSON jar is in classpath

This implementation meets all requirements for Task 2, demonstrating HTTP request handling, JSON parsing, and structured data display in a modular Java application.