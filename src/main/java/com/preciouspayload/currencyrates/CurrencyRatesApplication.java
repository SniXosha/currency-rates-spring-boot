package com.preciouspayload.currencyrates;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import static org.springframework.boot.SpringApplication.run;

@EnableCaching
@SpringBootApplication
public class CurrencyRatesApplication {
	public static void main(String[] args) {
		run(CurrencyRatesApplication.class, args);
	}
}
