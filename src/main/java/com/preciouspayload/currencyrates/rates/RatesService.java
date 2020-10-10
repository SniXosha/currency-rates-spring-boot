package com.preciouspayload.currencyrates.rates;

import java.util.List;

public interface RatesService {
    List<DailyRatesDto> ratesForMonth();
}
