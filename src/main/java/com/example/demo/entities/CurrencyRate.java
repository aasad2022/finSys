package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Currencies_Rate")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()//fetch = FetchType.LAZY
    @JoinColumn(name = "from_currency_id")
    private Currency fromCurrency;

    @ManyToOne()//fetch = FetchType.LAZY
    @JoinColumn(name = "to_currency_id")
    private Currency toCurrency;

    @Column(name = "rate_date")
    private Date rateDate;

    @Column(name = "sale_rate")
    private Double saleRate;

    @Column(name = "purchase_rate")
    private Double purchaseRate;

    @Column(name = "insert_user")
    private String insertUser;

    @Column(name = "insert_date")
    private Date insertDate;

    @Column(name = "insert_ip_address")
    private String insertIpAddress;

    @Column(name = "last_update_user")
    private String lastUpdateUser;

    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column(name = "last_update_ip_address")
    private String lastUpdateIpAddress;

    public CurrencyRate(Currency fromCurrency, Currency toCurrency, Date rateDate, Double saleRate, Double purchaseRate, String insertUser, Date insertDate, String insertIpAddress, String lastUpdateUser, Date lastUpdateDate, String lastUpdateIpAddress) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rateDate = rateDate;
        this.saleRate = saleRate;
        this.purchaseRate = purchaseRate;
        this.insertUser = insertUser;
        this.insertDate = insertDate;
        this.insertIpAddress = insertIpAddress;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateIpAddress = lastUpdateIpAddress;
    }
}
