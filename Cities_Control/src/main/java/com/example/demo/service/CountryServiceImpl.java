package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.model.city;
import com.example.demo.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CountryServiceImpl implements CountryService{

    private CountryRepository countryRepository;
    @Autowired
    public CountryServiceImpl(CountryRepository cityRepository) {

        this.countryRepository = countryRepository;
    }

  
    @Override
    public city findcitiesByCountry_Name(String name) {
        city model=countryRepository.findcitiesByCountry_Name(name);
        if(model==null)
        {            throw new NoSuchElementException();
        }
        return model;
    }

	@Override
	public Country createCountry(Country country) {
		// TODO Auto-generated method stub
		return countryRepository.save(country);
	}


	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}


}
