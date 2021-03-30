package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class Citycontroller {

    private CountryService countryService;
    @Autowired

    public Citycontroller(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "cities")
    public ResponseEntity  GetAllCities(){
    return (ResponseEntity) countryService.getAllCountry();
    }
    @GetMapping(path="/countries")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
    	return ResponseEntity.ok(countryService.createCountry(country));
    }
    
    

}
