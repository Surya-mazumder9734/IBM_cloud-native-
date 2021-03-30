package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.model.city;

import java.util.List;

public interface CountryService {
    public city findcitiesByCountry_Name(String name);
	 public List<Country> getAllCountry();
	 public Country createCountry(Country country);
}
