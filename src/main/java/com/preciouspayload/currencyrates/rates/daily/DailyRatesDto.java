package com.preciouspayload.currencyrates.rates.daily;

import lombok.Data;
import lombok.SneakyThrows;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.time.LocalDate;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static java.util.stream.IntStream.range;
import static javax.xml.parsers.DocumentBuilderFactory.*;

@Data
public class DailyRatesDto {
    private final LocalDate date;
    private final Map<String, Double> rates;

    @SneakyThrows
    public static DailyRatesDto fromXml(String xml, LocalDate date) {
        NodeList nodeList = newDefaultInstance()
                .newDocumentBuilder()
                .parse(new InputSource(new StringReader(xml)))
                .getDocumentElement()
                .getChildNodes();
        Map<String, Double> rates = range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .map(node -> (Element) node)
                .collect(toUnmodifiableMap(
                        el -> xmlValue(el, "CharCode"),
                        el -> parseDouble(xmlValue(el, "Value").replace(",", "."))));
        return new DailyRatesDto(date, rates);
    }

    private static String xmlValue(Element el, String charCode) {
        return el.getElementsByTagName(charCode)
                .item(0)
                .getTextContent();
    }
}
