package com.preciouspayload.currencyrates.rates.daily;

import com.preciouspayload.currencyrates.rates.DailyRatesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static com.preciouspayload.currencyrates.rates.DailyRatesDto.fromXml;
import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ofPattern;

@Service
@RequiredArgsConstructor
public class CbrDailyRatesService implements DailyRatesService {
    @Value("${rates.url}")
    private String url;

    private final RestTemplate restTemplate;

    @Override
    public DailyRatesDto rateFor(LocalDate date) {
        String xml = restTemplate.getForObject(format(url, ofPattern("dd/MM/yyyy").format(date)), String.class);
        return fromXml(xml, date);
    }
}
