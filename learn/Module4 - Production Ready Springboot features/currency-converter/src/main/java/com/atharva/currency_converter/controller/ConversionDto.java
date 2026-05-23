package com.atharva.currency_converter.controller;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class ConversionDto {
    // (data)
    /*
     * stores a list of currency -> val
     * W.R.T base currency
     * */
    @NotNull
    Map<String, Double> data;
}