package com.preciouspayload.currencyrates.rates.daily;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CachedDailyRatesService implements DailyRatesService {
    @Qualifier("cbrDailyRatesService")
    private final DailyRatesService dailyRatesService;

    @Override
    @Cacheable("rates")
    public DailyRatesDto rateFor(LocalDate date) {
        return dailyRatesService.rateFor(date);
    }
}
