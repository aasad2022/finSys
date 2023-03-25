package com.example.demo.init;

import com.example.demo.entities.Currency;
import com.example.demo.entities.CurrencyRate;
import com.example.demo.repositories.CurrencyRateRepository;
import com.example.demo.repositories.CurrencyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInit  implements CommandLineRunner {
 
    private final CurrencyRepository currencyRepository; 
    private final CurrencyRateRepository currencyRatesRepository;

    public DataInit(CurrencyRepository currencyRepository, CurrencyRateRepository currencyRatesRepository) {
        this.currencyRepository = currencyRepository;
        this.currencyRatesRepository = currencyRatesRepository;
    }

    @Override
    public void run(String...args) throws Exception {
        
        Currency currencyIls = new Currency("شيكل", "ILS",  true, "aasad",new Date(), "1.1.1.1", "aasad",new Date(), "1.1.1.1");
        Currency currencyJod = new Currency("دينار", "JOD",  false,  "aasad",new Date(), "1.1.1.1", "aasad",new Date(), "1.1.1.1");
        Currency currencyUsd = new Currency("دولار", "USD",  false, "aasad",new Date(), "1.1.1.1", "aasad",new Date(), "1.1.1.1");
        Currency currencyEuro = new Currency("يورو", "EURO",  false,"aasad",new Date(), "1.1.1.1", "aasad",new Date(), "1.1.1.1");
     
        currencyRepository.save(currencyIls);
        currencyRepository.save(currencyJod);
        currencyRepository.save(currencyUsd);
        currencyRepository.save(currencyEuro);

        CurrencyRate currencyRatesJodToIls = new CurrencyRate(currencyJod,currencyIls, new Date(), 5.3,5.0, "aasad",new Date(), "1.1.1.1", "aasad",new Date(), "1.1.1.1");
        currencyRatesRepository.save(currencyRatesJodToIls);
           
    }
     
}
