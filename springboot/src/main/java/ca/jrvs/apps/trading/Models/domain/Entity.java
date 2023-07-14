package ca.jrvs.apps.trading.Models.domain;
public interface Entity<ID>{
    ID getId();
    void setId(ID id);
}
