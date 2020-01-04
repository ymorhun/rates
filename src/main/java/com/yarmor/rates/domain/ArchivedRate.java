package com.yarmor.rates.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "archived_rates")
public class ArchivedRate {
    @Id
    private String id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "base_currency_id")
    private Currency baseCurrency;
    @ManyToOne(optional = false)
    @JoinColumn(name = "foreign_currency_id")
    private Currency foreignCurrency;
    private Date retrievedAt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "system_id")
    private System source;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(Currency foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public Date getRetrievedAt() {
        return retrievedAt;
    }

    public void setRetrievedAt(Date retrievedAt) {
        this.retrievedAt = retrievedAt;
    }

    public System getSource() {
        return source;
    }

    public void setSource(System source) {
        this.source = source;
    }
}
