package com.example.demo.repositories;

import com.example.demo.entities.Currency;
import com.example.demo.entities.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    List<CurrencyRate> findByFromCurrencyAndRateDate(Currency fromCurrency, Date rateDate);

    @Query("SELECT MAX(r.saleRate) FROM CurrencyRate r WHERE r.toCurrency = :toCurrency AND r.rateDate = :rateDate")
    Double findMaxSaleRateByToCurrencyAndRateDate(@Param("toCurrency") Currency toCurrency, @Param("rateDate") Date rateDate);

    List<CurrencyRate> findMaxByFromCurrencyAndToCurrency(Currency fromCurrency,Currency toCurrency);
}