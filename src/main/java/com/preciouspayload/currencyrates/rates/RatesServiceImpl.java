package com.preciouspayload.currencyrates.rates;

import com.preciouspayload.currencyrates.rates.daily.DailyRatesDto;
import com.preciouspayload.currencyrates.rates.daily.DailyRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

@Service
@RequiredArgsConstructor
public class RatesServiceImpl implements RatesService {
    @Qualifier("cachedDailyRatesService")
    private final DailyRatesService dailyRatesService;

    @Override
    public List<DailyRatesDto> rates(int days) {
        LocalDate current = now();
        return range(0, days)
                .mapToObj(current::minusDays)
                .map(dailyRatesService::rateFor)
                .collect(toList());
    }
}
