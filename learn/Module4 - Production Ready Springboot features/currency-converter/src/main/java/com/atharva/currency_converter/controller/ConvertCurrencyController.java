package com.atharva.currency_converter.controller;

import com.atharva.currency_converter.service.ConvertCurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ConvertCurrencyController {
    private final ConvertCurrencyService convertCurrencyService;

    @PostMapping("/convertCurrency")
    public ConversionDto convertCurrency(@RequestBody @Valid CurrencyListDto currencyListDto) {
        return convertCurrencyService.convert(currencyListDto);
    }
}
