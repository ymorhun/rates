package com.yarmor.rates.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RateEmbeddedId {
    @ManyToOne(optional = false)
    @JoinColumn(name = "base_currency_id")
    private Currency baseCurrency;
    @ManyToOne(optional = false)
    @JoinColumn(name = "foreign_currency_id")
    private Currency foreignCurrency;

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
}
