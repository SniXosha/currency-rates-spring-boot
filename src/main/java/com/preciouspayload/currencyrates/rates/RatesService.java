package com.preciouspayload.currencyrates.rates;

import com.preciouspayload.currencyrates.rates.daily.DailyRatesDto;

import java.util.List;

public interface RatesService {
    List<DailyRatesDto> rates(int days);
}
