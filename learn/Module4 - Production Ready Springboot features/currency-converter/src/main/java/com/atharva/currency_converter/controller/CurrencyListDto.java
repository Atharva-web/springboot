package com.atharva.currency_converter.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CurrencyListDto {
    String baseCurrency;
    List<String> listOfCurrencies;
}
