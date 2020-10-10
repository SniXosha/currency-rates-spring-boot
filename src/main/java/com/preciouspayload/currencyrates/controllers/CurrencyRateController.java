package com.preciouspayload.currencyrates.controllers;

import com.preciouspayload.currencyrates.rates.daily.DailyRatesDto;
import com.preciouspayload.currencyrates.rates.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyRateController {
    private final RatesService ratesService;

    @GetMapping("/rates")
    public List<DailyRatesDto> ratesForMonth(@RequestParam int days) {
        return ratesService.rates(days);
    }
}
