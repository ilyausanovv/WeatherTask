package ru.stud.kpfu.usanov.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class WeatherService {

    private final String keyApi = "50da205a9c76cfaf41a554bc57768910";

    public String getInfo(String cityName) throws IOException {

        URL getUrl = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + keyApi);

        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder stringBuilder;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            stringBuilder = new StringBuilder();
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                stringBuilder.append(input);
            }
        }

        connection.disconnect();
        return stringBuilder.toString();
    }
}
