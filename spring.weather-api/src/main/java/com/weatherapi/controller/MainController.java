package com.weatherapi.controller;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.service.WeatherService;

@RestController
@RequestMapping("/getweather")
public class MainController {
	
	 @Autowired
	 private WeatherService weatherService;
	
	
		@GetMapping("/{city}")
		public Map<String,Object> getWeather(@PathVariable("city") String city)
		{
			String JSON_SOURCE =  this.weatherService.getWeatherByCityName(city);
		    
			try {
				Map<String,Object> result =
				        new ObjectMapper().readValue(JSON_SOURCE, HashMap.class);
				         
//				        for(Map.Entry<String,Object> entry : result.entrySet()) {
//				        	
//				        	 
//				        }
				
				
				
				return  result;
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return  null;
		}

}
