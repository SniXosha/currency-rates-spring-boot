package com.preciouspayload.currencyrates.controllers;

import com.preciouspayload.currencyrates.rates.DailyRatesDto;
import com.preciouspayload.currencyrates.rates.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyRateController {
    private final RatesService ratesService;

    @GetMapping("/ratesForMonth")
    public List<DailyRatesDto> ratesForMonth() {
        return ratesService.ratesForMonth();
    }
}
