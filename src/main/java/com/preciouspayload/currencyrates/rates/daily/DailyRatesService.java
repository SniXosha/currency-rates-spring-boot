package com.preciouspayload.currencyrates.rates.daily;

import com.preciouspayload.currencyrates.rates.DailyRatesDto;

import java.time.LocalDate;

public interface DailyRatesService {
    DailyRatesDto rateFor(LocalDate date);
}
