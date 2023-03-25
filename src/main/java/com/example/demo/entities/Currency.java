package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "currencies")
public class Currency {
    @Id
    @Column(name = "currency_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "is_main_currency")
    private boolean isMainCurrency;

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

    public Currency(String currencyName, String currencyCode, boolean isMainCurrency, String insertUser, Date insertDate, String insertIpAddress, String lastUpdateUser, Date lastUpdateDate, String lastUpdateIpAddress) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.isMainCurrency = isMainCurrency;
        this.insertUser = insertUser;
        this.insertDate = insertDate;
        this.insertIpAddress = insertIpAddress;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateIpAddress = lastUpdateIpAddress;
    }
}
