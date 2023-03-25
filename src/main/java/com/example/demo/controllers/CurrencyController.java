package com.example.demo.controllers;

import com.example.demo.entities.Currency;
import com.example.demo.entities.CurrencyRate;
import com.example.demo.services.CurrencyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public Currency saveCurrency(@RequestBody Currency currency) {
        return currencyService.saveCurrency(currency);
    }

    @DeleteMapping("/{currencyId}")
    public void deleteCurrency(@PathVariable Long currencyId) {
        currencyService.deleteCurrency(currencyId);
    }

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/{currencyId}")
    public Currency getCurrency(@PathVariable Long currencyId) {
        return currencyService.getCurrency(currencyId);
    }

    @PostMapping("/rates")
    public CurrencyRate saveCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        return currencyService.saveCurrencyRate(currencyRate);
    }
    @GetMapping("/rates")
    public List<CurrencyRate> getAllCurrencyRate() {
        return currencyService.getAllCurrencyRate();
    }


    @GetMapping("/rates/{fromCurrencyId}/{toCurrencyId}")
    public Double getMaxSaleRateCurrency(@PathVariable Long fromCurrencyId,@PathVariable Long toCurrencyId) {
        return currencyService.getMaxSaleRateCurrency(fromCurrencyId,toCurrencyId);
    }

//    @GetMapping("/rates/{toCurrencyId}/{rateDate}")
//    public Double getMaxSaleRateByToCurrencyAndRateDate(@PathVariable Long toCurrencyId, @PathVariable @DateTimeFormat(pattern = "dd/MM/yyyy") Date rateDate) {
//        return currencyService.getMaxSaleRateByToCurrencyAndRateDate(toCurrencyId, rateDate);
//    }
//
//    @GetMapping("/rates/{fromCurrencyId}/{rateDate}")
//    public List<CurrencyRate> getRatesByFromCurrencyAndRateDate(@PathVariable Long fromCurrencyId, @PathVariable @DateTimeFormat(pattern = "dd/MM/yyyy") Date rateDate) {
//        return currencyService.getCurrencyRatesByFromCurrencyAndRateDate(fromCurrencyId, rateDate);
//    }
}
