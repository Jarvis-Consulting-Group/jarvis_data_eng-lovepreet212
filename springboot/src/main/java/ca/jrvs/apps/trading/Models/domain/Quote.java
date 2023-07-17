package ca.jrvs.apps.trading.Models.domain;

public class Quote implements Entity<String> {
    private String ticker;
    private Double lastPrice;
    private Double bidPrice;
    private Integer bidSize;
    private Double askPrice;
    private Integer askSize;

    @Override
    public String getId() {
        return ticker;
    }

    @Override
    public void setId(String id) {
        this.ticker=id;
    }

    public String getTicker() {
        return ticker;
    }

    public Quote setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public Quote setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
        return this;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public Quote setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public Integer getBidSize() {
        return bidSize;
    }

    public Quote setBidSize(Integer bidSize) {
        this.bidSize = bidSize;
        return this;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public Quote setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    public Integer getAskSize() {
        return askSize;
    }

    public Quote setAskSize(Integer askSize) {
        this.askSize = askSize;
        return this;
    }
}
