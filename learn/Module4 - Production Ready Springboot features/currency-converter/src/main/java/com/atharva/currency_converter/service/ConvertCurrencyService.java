package com.atharva.currency_converter.service;

import com.atharva.currency_converter.controller.ConversionDto;
import com.atharva.currency_converter.controller.CurrencyListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ConvertCurrencyService {
    @Value("${currency.convert.apikey}")
    private String apiKey;

    private final RestClient restClient;

    public ConvertCurrencyService(@Value("${currency.convert.base.url}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    Logger log = LoggerFactory.getLogger(ConvertCurrencyService.class);

    public ConversionDto convert(CurrencyListDto currencyListDto) {
        // prepare query param for the external api
        String paramCurrencyList = String.join(",", currencyListDto.getListOfCurrencies());
        // call the api
        ConversionDto conversionDto = restClient.get().uri(uriBuilder ->
                uriBuilder
                        .queryParam("apikey", apiKey)
                        .queryParam("base_currency", currencyListDto.getBaseCurrency())
                        .queryParam("currencies", paramCurrencyList)
                        .build())
                .retrieve()
                .body(ConversionDto.class);

        log.info("Size of map: {}", conversionDto.getData().size());

        return conversionDto;
    }
}
