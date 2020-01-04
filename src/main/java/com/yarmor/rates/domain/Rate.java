package com.yarmor.rates.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rates")
public class Rate {
    @EmbeddedId
    private RateEmbeddedId id;
    private Date retrievedAt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "system_id")
    private System source;

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

    public RateEmbeddedId getId() {
        return id;
    }

    public void setId(RateEmbeddedId id) {
        this.id = id;
    }
}
