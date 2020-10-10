package com.preciouspayload.currencyrates.rates.daily;

import java.time.LocalDate;

public interface DailyRatesService {
    DailyRatesDto rateFor(LocalDate date);
}
