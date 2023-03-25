package com.example.demo.services;

import com.example.demo.entities.Currency;
import com.example.demo.entities.CurrencyRate;
import com.example.demo.repositories.CurrencyRateRepository;
import com.example.demo.repositories.CurrencyRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyService(CurrencyRepository currencyRepository, CurrencyRateRepository currencyRateRepository) {
        this.currencyRepository = currencyRepository;
        this.currencyRateRepository = currencyRateRepository;
    }

    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    public void deleteCurrency(Long currencyId) {
        currencyRepository.deleteById(currencyId);
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrency(Long currencyId) {
        Currency currency= currencyRepository.findById(currencyId).orElse(null);//.orElseThrow(() -> new NotFoundException("Currency not found with ID " + currencyId));
        return currency;
    }
    public CurrencyRate saveCurrencyRate(CurrencyRate currencyRate) {
        return currencyRateRepository.save(currencyRate);
    }

    public List<CurrencyRate> getAllCurrencyRate() {
        return currencyRateRepository.findAll();
    }
    public Double getMaxSaleRateCurrency(Long fromCurrencyId,Long toCurrencyId) {
        Currency fromCurrency= currencyRepository.findById(fromCurrencyId).orElse(null);
        Currency toCurrency= currencyRepository.findById(toCurrencyId).orElse(null);
        List<CurrencyRate> currencyRate = currencyRateRepository.findMaxByFromCurrencyAndToCurrency(fromCurrency,toCurrency);
        return  currencyRate!=null && currencyRate.size()>0?currencyRate.get(0).getSaleRate():null;
    }
    public Double getMaxSaleRateByToCurrencyAndRateDate(Long toCurrencyId, Date rateDate) {
        Currency toCurrency = currencyRepository.findById(toCurrencyId).orElse(null);//.orElseThrow(() -> new NotFoundException("Currency not found with ID: " + toCurrencyId));
        return currencyRateRepository.findMaxSaleRateByToCurrencyAndRateDate(toCurrency, rateDate);
    }

    public List<CurrencyRate> getCurrencyRatesByFromCurrencyAndRateDate(Long fromCurrencyId, Date rateDate) {
        Currency fromCurrency = currencyRepository.findById(fromCurrencyId).orElse(null);//.orElseThrow(() -> new NotFoundException("Currency not found with ID: " + fromCurrencyId));
        return currencyRateRepository.findByFromCurrencyAndRateDate(fromCurrency, rateDate);
    }
}
