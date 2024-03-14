package web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

  @GetMapping("/getWeather")
  public String getWeather(@RequestParam(value = "name") String name) {
    RestTemplate rest = new RestTemplate();
    
    String endpoint = "https://weather.tsukumijima.net/api/forecast";
    String id = "230010";
    String url = endpoint + "?city=" + id;
    
    var response = rest.getForEntity(url, String.class);
    String json = response.getBody();
    return json;
  }

}