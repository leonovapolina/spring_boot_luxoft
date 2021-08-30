package com.luxoft.training.springboot;

import com.luxoft.training.springboot.dao.CountryDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		CountryDao countryDao = context.getBean(CountryDao.class);

		System.out.println(countryDao.getCountryList());
		System.out.println(countryDao.getCountryByCodeName("RU"));

		countryDao.updateCountryName("RU", "RUSSIA");
		System.out.println(countryDao.getCountryByCodeName("RU"));
	}

}
