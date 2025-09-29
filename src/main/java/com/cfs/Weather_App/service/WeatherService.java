package com.cfs.Weather_App.service;


import com.cfs.Weather_App.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService
{


    @Value("${weather.api.key}")
    private String apikey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.forecast.url}")
    private String apiForecastUrl;


    private final RestTemplate template =new RestTemplate();

    public String test()
    {
        return "good";
    }

    public WeatherResponse getData(String city)
    {
        String url =apiUrl +"?key="+apikey+"&q="+city;
       Root response= template.getForObject(url,Root.class);
        WeatherResponse weatherResponse=new WeatherResponse();

        assert response != null;
        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);
       String condition= response.getCurrent().getCondition().getText();
       weatherResponse.setCondition(condition);
       weatherResponse.setTemperature(response.getCurrent().getTemp_c());
        return weatherResponse;

    }

    public WeatherForecast getForecast(String city , int days)
    {

        WeatherForecast weatherForecast=new WeatherForecast();

        WeatherResponse weatherResponse= getData(city);


      WeatherForecast response  =new WeatherForecast();

      response.setWeatherResponse(weatherResponse);


        List<DayTemp>dayList =new ArrayList<>();

        String url =apiForecastUrl +"?key="+apikey+"&q="+city+"&days="+days;
        Root apiResponse= template.getForObject(url,Root.class);
        assert apiResponse != null;
        Forecast forecast = apiResponse.getForecast();
        ArrayList<Forecastday>forecastday= forecast.getForecastday();
        for (Forecastday rs: forecastday)
        {
            DayTemp d= new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().getMintemp_c());
            d.setAvgTemp(rs.getDay().getAvgtemp_c());
            d.setMaxTemp(rs.getDay().getMaxtemp_c());
            dayList.add(d);

        }
        response.setDayTemp(dayList);
        return response;
    }

}
