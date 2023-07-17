package ca.jrvs.apps.trading.Models.domain;


import ca.jrvs.apps.trading.Models.domain.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Annotation;

@Table
public class Account implements Entity<Integer> {
    @Id
    private Integer id;
    private Integer traderId;
    private Double amount;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTraderId() {
        return traderId;
    }

    public void setTraderId(Integer traderId) {
        this.traderId = traderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
