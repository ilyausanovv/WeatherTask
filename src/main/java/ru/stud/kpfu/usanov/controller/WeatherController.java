package ru.stud.kpfu.usanov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stud.kpfu.usanov.service.WeatherService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weatherInfo")
    public String weatherInfo(@RequestParam Optional<String> cityName) throws IOException {
        return weatherService.getInfo(cityName.orElse("Kazan"));
    }
}
