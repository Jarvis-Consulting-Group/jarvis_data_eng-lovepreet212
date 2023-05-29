package ca.jrvs.apps.trading.Models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "companyName",
        "primaryExchange",
        "calculationPrice",
        "open",
        "openTime",
        "openSource",
        "close",
        "closeTime",
        "closeSource",
        "high",
        "highTime",
        "highSource",
        "low",
        "lowTime",
        "lowSource",
        "latestPrice",
        "latestSource",
        "latestTime",
        "latestUpdate",
        "latestVolume",
        "iexRealtimePrice",
        "iexRealtimeSize",
        "iexLastUpdated",
        "delayedPrice",
        "delayedPriceTime",
        "oddLotDelayedPrice",
        "oddLotDelayedPriceTime",
        "extendedPrice",
        "extendedChange",
        "extendedChangePercent",
        "extendedPriceTime",
        "previousClose",
        "previousVolume",
        "change",
        "changePercent",
        "volume",
        "iexMarketPercent",
        "iexVolume",
        "avgTotalVolume",
        "iexBidPrice",
        "iexBidSize",
        "iexAskPrice",
        "iexAskSize",
        "iexOpen",
        "iexOpenTime",
        "iexClose",
        "iexCloseTime",
        "marketCap",
        "peRatio",
        "week52High",
        "week52Low",
        "ytdChange",
        "lastTradeTime",
        "currency",
        "isUSMarketOpen"
})
public class IexQuote {

    @JsonProperty("symbol")
    private Object symbol;
    @JsonProperty("companyName")
    private Object companyName;
    @JsonProperty("primaryExchange")
    private Object primaryExchange;
    @JsonProperty("calculationPrice")
    private Object calculationPrice;
    @JsonProperty("open")
    private Object open;
    @JsonProperty("openTime")
    private Object openTime;
    @JsonProperty("openSource")
    private Object openSource;
    @JsonProperty("close")
    private Object close;
    @JsonProperty("closeTime")
    private Object closeTime;
    @JsonProperty("closeSource")
    private Object closeSource;
    @JsonProperty("high")
    private Object high;
    @JsonProperty("highTime")
    private Object highTime;
    @JsonProperty("highSource")
    private Object highSource;
    @JsonProperty("low")
    private Object low;
    @JsonProperty("lowTime")
    private Object lowTime;
    @JsonProperty("lowSource")
    private Object lowSource;
    @JsonProperty("latestPrice")
    private Object latestPrice;
    @JsonProperty("latestSource")
    private Object latestSource;
    @JsonProperty("latestTime")
    private Object latestTime;
    @JsonProperty("latestUpdate")
    private Object latestUpdate;
    @JsonProperty("latestVolume")
    private Object latestVolume;
    @JsonProperty("iexRealtimePrice")
    private Object iexRealtimePrice;
    @JsonProperty("iexRealtimeSize")
    private Object iexRealtimeSize;
    @JsonProperty("iexLastUpdated")
    private Object iexLastUpdated;
    @JsonProperty("delayedPrice")
    private Object delayedPrice;
    @JsonProperty("delayedPriceTime")
    private Object delayedPriceTime;
    @JsonProperty("oddLotDelayedPrice")
    private Object oddLotDelayedPrice;
    @JsonProperty("oddLotDelayedPriceTime")
    private Object oddLotDelayedPriceTime;
    @JsonProperty("extendedPrice")
    private Object extendedPrice;
    @JsonProperty("extendedChange")
    private Object extendedChange;
    @JsonProperty("extendedChangePercent")
    private Object extendedChangePercent;
    @JsonProperty("extendedPriceTime")
    private Object extendedPriceTime;
    @JsonProperty("previousClose")
    private Object previousClose;
    @JsonProperty("previousVolume")
    private Object previousVolume;
    @JsonProperty("change")
    private Object change;
    @JsonProperty("changePercent")
    private Object changePercent;
    @JsonProperty("volume")
    private Object volume;
    @JsonProperty("iexMarketPercent")
    private Object iexMarketPercent;
    @JsonProperty("iexVolume")
    private Object iexVolume;
    @JsonProperty("avgTotalVolume")
    private Object avgTotalVolume;
    @JsonProperty("iexBidPrice")
    private Object iexBidPrice;
    @JsonProperty("iexBidSize")
    private Object iexBidSize;
    @JsonProperty("iexAskPrice")
    private Object iexAskPrice;
    @JsonProperty("iexAskSize")
    private Object iexAskSize;
    @JsonProperty("iexOpen")
    private Object iexOpen;
    @JsonProperty("iexOpenTime")
    private Object iexOpenTime;
    @JsonProperty("iexClose")
    private Object iexClose;
    @JsonProperty("iexCloseTime")
    private Object iexCloseTime;
    @JsonProperty("marketCap")
    private Object marketCap;
    @JsonProperty("peRatio")
    private Object peRatio;
    @JsonProperty("week52High")
    private Object week52High;
    @JsonProperty("week52Low")
    private Object week52Low;
    @JsonProperty("ytdChange")
    private Object ytdChange;
    @JsonProperty("lastTradeTime")
    private Object lastTradeTime;
    @JsonProperty("currency")
    private Object currency;
    @JsonProperty("isUSMarketOpen")
    private Object isUSMarketOpen;

    /**
     * No args constructor for use in serialization
     *
     */
    public IexQuote() {
    }

    /**
     *
     * @param symbol
     * @param highTime
     * @param avgTotalVolume
     * @param companyName
     * @param openSource
     * @param delayedPrice
     * @param iexMarketPercent
     * @param primaryExchange
     * @param latestUpdate
     * @param high
     * @param iexOpenTime
     * @param delayedPriceTime
     * @param extendedPrice
     * @param week52Low
     * @param highSource
     * @param latestPrice
     * @param marketCap
     * @param iexClose
     * @param volume
     * @param ytdChange
     * @param lastTradeTime
     * @param closeSource
     * @param extendedChange
     * @param iexRealtimePrice
     * @param calculationPrice
     * @param extendedChangePercent
     * @param latestSource
     * @param iexOpen
     * @param iexBidPrice
     * @param previousClose
     * @param peRatio
     * @param isUSMarketOpen
     * @param low
     * @param oddLotDelayedPrice
     * @param extendedPriceTime
     * @param closeTime
     * @param changePercent
     * @param currency
     * @param week52High
     * @param openTime
     * @param close
     * @param iexCloseTime
     * @param oddLotDelayedPriceTime
     * @param previousVolume
     * @param iexRealtimeSize
     * @param iexLastUpdated
     * @param change
     * @param latestVolume
     * @param iexAskPrice
     * @param lowSource
     * @param iexVolume
     * @param iexAskSize
     * @param latestTime
     * @param open
     * @param lowTime
     * @param iexBidSize
     */
    public IexQuote(Object symbol, Object companyName, Object primaryExchange, Object calculationPrice, Object open, Object openTime, Object openSource, Object close, Object closeTime, Object closeSource, Object high, Object highTime, Object highSource, Object low, Object lowTime, Object lowSource, Object latestPrice, Object latestSource, Object latestTime, Object latestUpdate, Object latestVolume, Object iexRealtimePrice, Object iexRealtimeSize, Object iexLastUpdated, Object delayedPrice, Object delayedPriceTime, Object oddLotDelayedPrice, Object oddLotDelayedPriceTime, Object extendedPrice, Object extendedChange, Object extendedChangePercent, Object extendedPriceTime, Object previousClose, Object previousVolume, Object change, Object changePercent, Object volume, Object iexMarketPercent, Object iexVolume, Object avgTotalVolume, Object iexBidPrice, Object iexBidSize, Object iexAskPrice, Object iexAskSize, Object iexOpen, Object iexOpenTime, Object iexClose, Object iexCloseTime, Object marketCap, Object peRatio, Object week52High, Object week52Low, Object ytdChange, Object lastTradeTime, Object currency, Object isUSMarketOpen) {
        super();
        this.symbol = symbol;
        this.companyName = companyName;
        this.primaryExchange = primaryExchange;
        this.calculationPrice = calculationPrice;
        this.open = open;
        this.openTime = openTime;
        this.openSource = openSource;
        this.close = close;
        this.closeTime = closeTime;
        this.closeSource = closeSource;
        this.high = high;
        this.highTime = highTime;
        this.highSource = highSource;
        this.low = low;
        this.lowTime = lowTime;
        this.lowSource = lowSource;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexLastUpdated = iexLastUpdated;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        this.extendedPrice = extendedPrice;
        this.extendedChange = extendedChange;
        this.extendedChangePercent = extendedChangePercent;
        this.extendedPriceTime = extendedPriceTime;
        this.previousClose = previousClose;
        this.previousVolume = previousVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.volume = volume;
        this.iexMarketPercent = iexMarketPercent;
        this.iexVolume = iexVolume;
        this.avgTotalVolume = avgTotalVolume;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.iexOpen = iexOpen;
        this.iexOpenTime = iexOpenTime;
        this.iexClose = iexClose;
        this.iexCloseTime = iexCloseTime;
        this.marketCap = marketCap;
        this.peRatio = peRatio;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.lastTradeTime = lastTradeTime;
        this.currency = currency;
        this.isUSMarketOpen = isUSMarketOpen;
    }

    @JsonProperty("symbol")
    public Object getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(Object symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("companyName")
    public Object getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("primaryExchange")
    public Object getPrimaryExchange() {
        return primaryExchange;
    }

    @JsonProperty("primaryExchange")
    public void setPrimaryExchange(Object primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    @JsonProperty("calculationPrice")
    public Object getCalculationPrice() {
        return calculationPrice;
    }

    @JsonProperty("calculationPrice")
    public void setCalculationPrice(Object calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    @JsonProperty("open")
    public Object getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(Object open) {
        this.open = open;
    }

    @JsonProperty("openTime")
    public Object getOpenTime() {
        return openTime;
    }

    @JsonProperty("openTime")
    public void setOpenTime(Object openTime) {
        this.openTime = openTime;
    }

    @JsonProperty("openSource")
    public Object getOpenSource() {
        return openSource;
    }

    @JsonProperty("openSource")
    public void setOpenSource(Object openSource) {
        this.openSource = openSource;
    }

    @JsonProperty("close")
    public Object getClose() {
        return close;
    }

    @JsonProperty("close")
    public void setClose(Object close) {
        this.close = close;
    }

    @JsonProperty("closeTime")
    public Object getCloseTime() {
        return closeTime;
    }

    @JsonProperty("closeTime")
    public void setCloseTime(Object closeTime) {
        this.closeTime = closeTime;
    }

    @JsonProperty("closeSource")
    public Object getCloseSource() {
        return closeSource;
    }

    @JsonProperty("closeSource")
    public void setCloseSource(Object closeSource) {
        this.closeSource = closeSource;
    }

    @JsonProperty("high")
    public Object getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Object high) {
        this.high = high;
    }

    @JsonProperty("highTime")
    public Object getHighTime() {
        return highTime;
    }

    @JsonProperty("highTime")
    public void setHighTime(Object highTime) {
        this.highTime = highTime;
    }

    @JsonProperty("highSource")
    public Object getHighSource() {
        return highSource;
    }

    @JsonProperty("highSource")
    public void setHighSource(Object highSource) {
        this.highSource = highSource;
    }

    @JsonProperty("low")
    public Object getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Object low) {
        this.low = low;
    }

    @JsonProperty("lowTime")
    public Object getLowTime() {
        return lowTime;
    }

    @JsonProperty("lowTime")
    public void setLowTime(Object lowTime) {
        this.lowTime = lowTime;
    }

    @JsonProperty("lowSource")
    public Object getLowSource() {
        return lowSource;
    }

    @JsonProperty("lowSource")
    public void setLowSource(Object lowSource) {
        this.lowSource = lowSource;
    }

    @JsonProperty("latestPrice")
    public Object getLatestPrice() {
        return latestPrice;
    }

    @JsonProperty("latestPrice")
    public void setLatestPrice(Object latestPrice) {
        this.latestPrice = latestPrice;
    }

    @JsonProperty("latestSource")
    public Object getLatestSource() {
        return latestSource;
    }

    @JsonProperty("latestSource")
    public void setLatestSource(Object latestSource) {
        this.latestSource = latestSource;
    }

    @JsonProperty("latestTime")
    public Object getLatestTime() {
        return latestTime;
    }

    @JsonProperty("latestTime")
    public void setLatestTime(Object latestTime) {
        this.latestTime = latestTime;
    }

    @JsonProperty("latestUpdate")
    public Object getLatestUpdate() {
        return latestUpdate;
    }

    @JsonProperty("latestUpdate")
    public void setLatestUpdate(Object latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    @JsonProperty("latestVolume")
    public Object getLatestVolume() {
        return latestVolume;
    }

    @JsonProperty("latestVolume")
    public void setLatestVolume(Object latestVolume) {
        this.latestVolume = latestVolume;
    }

    @JsonProperty("iexRealtimePrice")
    public Object getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    @JsonProperty("iexRealtimePrice")
    public void setIexRealtimePrice(Object iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
    }

    @JsonProperty("iexRealtimeSize")
    public Object getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    @JsonProperty("iexRealtimeSize")
    public void setIexRealtimeSize(Object iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
    }

    @JsonProperty("iexLastUpdated")
    public Object getIexLastUpdated() {
        return iexLastUpdated;
    }

    @JsonProperty("iexLastUpdated")
    public void setIexLastUpdated(Object iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    @JsonProperty("delayedPrice")
    public Object getDelayedPrice() {
        return delayedPrice;
    }

    @JsonProperty("delayedPrice")
    public void setDelayedPrice(Object delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    @JsonProperty("delayedPriceTime")
    public Object getDelayedPriceTime() {
        return delayedPriceTime;
    }

    @JsonProperty("delayedPriceTime")
    public void setDelayedPriceTime(Object delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    @JsonProperty("oddLotDelayedPrice")
    public Object getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    @JsonProperty("oddLotDelayedPrice")
    public void setOddLotDelayedPrice(Object oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
    }

    @JsonProperty("oddLotDelayedPriceTime")
    public Object getOddLotDelayedPriceTime() {
        return oddLotDelayedPriceTime;
    }

    @JsonProperty("oddLotDelayedPriceTime")
    public void setOddLotDelayedPriceTime(Object oddLotDelayedPriceTime) {
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
    }

    @JsonProperty("extendedPrice")
    public Object getExtendedPrice() {
        return extendedPrice;
    }

    @JsonProperty("extendedPrice")
    public void setExtendedPrice(Object extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    @JsonProperty("extendedChange")
    public Object getExtendedChange() {
        return extendedChange;
    }

    @JsonProperty("extendedChange")
    public void setExtendedChange(Object extendedChange) {
        this.extendedChange = extendedChange;
    }

    @JsonProperty("extendedChangePercent")
    public Object getExtendedChangePercent() {
        return extendedChangePercent;
    }

    @JsonProperty("extendedChangePercent")
    public void setExtendedChangePercent(Object extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    @JsonProperty("extendedPriceTime")
    public Object getExtendedPriceTime() {
        return extendedPriceTime;
    }

    @JsonProperty("extendedPriceTime")
    public void setExtendedPriceTime(Object extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    @JsonProperty("previousClose")
    public Object getPreviousClose() {
        return previousClose;
    }

    @JsonProperty("previousClose")
    public void setPreviousClose(Object previousClose) {
        this.previousClose = previousClose;
    }

    @JsonProperty("previousVolume")
    public Object getPreviousVolume() {
        return previousVolume;
    }

    @JsonProperty("previousVolume")
    public void setPreviousVolume(Object previousVolume) {
        this.previousVolume = previousVolume;
    }

    @JsonProperty("change")
    public Object getChange() {
        return change;
    }

    @JsonProperty("change")
    public void setChange(Object change) {
        this.change = change;
    }

    @JsonProperty("changePercent")
    public Object getChangePercent() {
        return changePercent;
    }

    @JsonProperty("changePercent")
    public void setChangePercent(Object changePercent) {
        this.changePercent = changePercent;
    }

    @JsonProperty("volume")
    public Object getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Object volume) {
        this.volume = volume;
    }

    @JsonProperty("iexMarketPercent")
    public Object getIexMarketPercent() {
        return iexMarketPercent;
    }

    @JsonProperty("iexMarketPercent")
    public void setIexMarketPercent(Object iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    @JsonProperty("iexVolume")
    public Object getIexVolume() {
        return iexVolume;
    }

    @JsonProperty("iexVolume")
    public void setIexVolume(Object iexVolume) {
        this.iexVolume = iexVolume;
    }

    @JsonProperty("avgTotalVolume")
    public Object getAvgTotalVolume() {
        return avgTotalVolume;
    }

    @JsonProperty("avgTotalVolume")
    public void setAvgTotalVolume(Object avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    @JsonProperty("iexBidPrice")
    public Object getIexBidPrice() {
        return iexBidPrice;
    }

    @JsonProperty("iexBidPrice")
    public void setIexBidPrice(Object iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    @JsonProperty("iexBidSize")
    public Object getIexBidSize() {
        return iexBidSize;
    }

    @JsonProperty("iexBidSize")
    public void setIexBidSize(Object iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    @JsonProperty("iexAskPrice")
    public Object getIexAskPrice() {
        return iexAskPrice;
    }

    @JsonProperty("iexAskPrice")
    public void setIexAskPrice(Object iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    @JsonProperty("iexAskSize")
    public Object getIexAskSize() {
        return iexAskSize;
    }

    @JsonProperty("iexAskSize")
    public void setIexAskSize(Object iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    @JsonProperty("iexOpen")
    public Object getIexOpen() {
        return iexOpen;
    }

    @JsonProperty("iexOpen")
    public void setIexOpen(Object iexOpen) {
        this.iexOpen = iexOpen;
    }

    @JsonProperty("iexOpenTime")
    public Object getIexOpenTime() {
        return iexOpenTime;
    }

    @JsonProperty("iexOpenTime")
    public void setIexOpenTime(Object iexOpenTime) {
        this.iexOpenTime = iexOpenTime;
    }

    @JsonProperty("iexClose")
    public Object getIexClose() {
        return iexClose;
    }

    @JsonProperty("iexClose")
    public void setIexClose(Object iexClose) {
        this.iexClose = iexClose;
    }

    @JsonProperty("iexCloseTime")
    public Object getIexCloseTime() {
        return iexCloseTime;
    }

    @JsonProperty("iexCloseTime")
    public void setIexCloseTime(Object iexCloseTime) {
        this.iexCloseTime = iexCloseTime;
    }

    @JsonProperty("marketCap")
    public Object getMarketCap() {
        return marketCap;
    }

    @JsonProperty("marketCap")
    public void setMarketCap(Object marketCap) {
        this.marketCap = marketCap;
    }

    @JsonProperty("peRatio")
    public Object getPeRatio() {
        return peRatio;
    }

    @JsonProperty("peRatio")
    public void setPeRatio(Object peRatio) {
        this.peRatio = peRatio;
    }

    @JsonProperty("week52High")
    public Object getWeek52High() {
        return week52High;
    }

    @JsonProperty("week52High")
    public void setWeek52High(Object week52High) {
        this.week52High = week52High;
    }

    @JsonProperty("week52Low")
    public Object getWeek52Low() {
        return week52Low;
    }

    @JsonProperty("week52Low")
    public void setWeek52Low(Object week52Low) {
        this.week52Low = week52Low;
    }

    @JsonProperty("ytdChange")
    public Object getYtdChange() {
        return ytdChange;
    }

    @JsonProperty("ytdChange")
    public void setYtdChange(Object ytdChange) {
        this.ytdChange = ytdChange;
    }

    @JsonProperty("lastTradeTime")
    public Object getLastTradeTime() {
        return lastTradeTime;
    }

    @JsonProperty("lastTradeTime")
    public void setLastTradeTime(Object lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    @JsonProperty("currency")
    public Object getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    @JsonProperty("isUSMarketOpen")
    public Object getIsUSMarketOpen() {
        return isUSMarketOpen;
    }

    @JsonProperty("isUSMarketOpen")
    public void setIsUSMarketOpen(Object isUSMarketOpen) {
        this.isUSMarketOpen = isUSMarketOpen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IexQuote.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("symbol");
        sb.append('=');
        sb.append(((this.symbol == null)?"<null>":this.symbol));
        sb.append(',');
        sb.append("companyName");
        sb.append('=');
        sb.append(((this.companyName == null)?"<null>":this.companyName));
        sb.append(',');
        sb.append("primaryExchange");
        sb.append('=');
        sb.append(((this.primaryExchange == null)?"<null>":this.primaryExchange));
        sb.append(',');
        sb.append("calculationPrice");
        sb.append('=');
        sb.append(((this.calculationPrice == null)?"<null>":this.calculationPrice));
        sb.append(',');
        sb.append("open");
        sb.append('=');
        sb.append(((this.open == null)?"<null>":this.open));
        sb.append(',');
        sb.append("openTime");
        sb.append('=');
        sb.append(((this.openTime == null)?"<null>":this.openTime));
        sb.append(',');
        sb.append("openSource");
        sb.append('=');
        sb.append(((this.openSource == null)?"<null>":this.openSource));
        sb.append(',');
        sb.append("close");
        sb.append('=');
        sb.append(((this.close == null)?"<null>":this.close));
        sb.append(',');
        sb.append("closeTime");
        sb.append('=');
        sb.append(((this.closeTime == null)?"<null>":this.closeTime));
        sb.append(',');
        sb.append("closeSource");
        sb.append('=');
        sb.append(((this.closeSource == null)?"<null>":this.closeSource));
        sb.append(',');
        sb.append("high");
        sb.append('=');
        sb.append(((this.high == null)?"<null>":this.high));
        sb.append(',');
        sb.append("highTime");
        sb.append('=');
        sb.append(((this.highTime == null)?"<null>":this.highTime));
        sb.append(',');
        sb.append("highSource");
        sb.append('=');
        sb.append(((this.highSource == null)?"<null>":this.highSource));
        sb.append(',');
        sb.append("low");
        sb.append('=');
        sb.append(((this.low == null)?"<null>":this.low));
        sb.append(',');
        sb.append("lowTime");
        sb.append('=');
        sb.append(((this.lowTime == null)?"<null>":this.lowTime));
        sb.append(',');
        sb.append("lowSource");
        sb.append('=');
        sb.append(((this.lowSource == null)?"<null>":this.lowSource));
        sb.append(',');
        sb.append("latestPrice");
        sb.append('=');
        sb.append(((this.latestPrice == null)?"<null>":this.latestPrice));
        sb.append(',');
        sb.append("latestSource");
        sb.append('=');
        sb.append(((this.latestSource == null)?"<null>":this.latestSource));
        sb.append(',');
        sb.append("latestTime");
        sb.append('=');
        sb.append(((this.latestTime == null)?"<null>":this.latestTime));
        sb.append(',');
        sb.append("latestUpdate");
        sb.append('=');
        sb.append(((this.latestUpdate == null)?"<null>":this.latestUpdate));
        sb.append(',');
        sb.append("latestVolume");
        sb.append('=');
        sb.append(((this.latestVolume == null)?"<null>":this.latestVolume));
        sb.append(',');
        sb.append("iexRealtimePrice");
        sb.append('=');
        sb.append(((this.iexRealtimePrice == null)?"<null>":this.iexRealtimePrice));
        sb.append(',');
        sb.append("iexRealtimeSize");
        sb.append('=');
        sb.append(((this.iexRealtimeSize == null)?"<null>":this.iexRealtimeSize));
        sb.append(',');
        sb.append("iexLastUpdated");
        sb.append('=');
        sb.append(((this.iexLastUpdated == null)?"<null>":this.iexLastUpdated));
        sb.append(',');
        sb.append("delayedPrice");
        sb.append('=');
        sb.append(((this.delayedPrice == null)?"<null>":this.delayedPrice));
        sb.append(',');
        sb.append("delayedPriceTime");
        sb.append('=');
        sb.append(((this.delayedPriceTime == null)?"<null>":this.delayedPriceTime));
        sb.append(',');
        sb.append("oddLotDelayedPrice");
        sb.append('=');
        sb.append(((this.oddLotDelayedPrice == null)?"<null>":this.oddLotDelayedPrice));
        sb.append(',');
        sb.append("oddLotDelayedPriceTime");
        sb.append('=');
        sb.append(((this.oddLotDelayedPriceTime == null)?"<null>":this.oddLotDelayedPriceTime));
        sb.append(',');
        sb.append("extendedPrice");
        sb.append('=');
        sb.append(((this.extendedPrice == null)?"<null>":this.extendedPrice));
        sb.append(',');
        sb.append("extendedChange");
        sb.append('=');
        sb.append(((this.extendedChange == null)?"<null>":this.extendedChange));
        sb.append(',');
        sb.append("extendedChangePercent");
        sb.append('=');
        sb.append(((this.extendedChangePercent == null)?"<null>":this.extendedChangePercent));
        sb.append(',');
        sb.append("extendedPriceTime");
        sb.append('=');
        sb.append(((this.extendedPriceTime == null)?"<null>":this.extendedPriceTime));
        sb.append(',');
        sb.append("previousClose");
        sb.append('=');
        sb.append(((this.previousClose == null)?"<null>":this.previousClose));
        sb.append(',');
        sb.append("previousVolume");
        sb.append('=');
        sb.append(((this.previousVolume == null)?"<null>":this.previousVolume));
        sb.append(',');
        sb.append("change");
        sb.append('=');
        sb.append(((this.change == null)?"<null>":this.change));
        sb.append(',');
        sb.append("changePercent");
        sb.append('=');
        sb.append(((this.changePercent == null)?"<null>":this.changePercent));
        sb.append(',');
        sb.append("volume");
        sb.append('=');
        sb.append(((this.volume == null)?"<null>":this.volume));
        sb.append(',');
        sb.append("iexMarketPercent");
        sb.append('=');
        sb.append(((this.iexMarketPercent == null)?"<null>":this.iexMarketPercent));
        sb.append(',');
        sb.append("iexVolume");
        sb.append('=');
        sb.append(((this.iexVolume == null)?"<null>":this.iexVolume));
        sb.append(',');
        sb.append("avgTotalVolume");
        sb.append('=');
        sb.append(((this.avgTotalVolume == null)?"<null>":this.avgTotalVolume));
        sb.append(',');
        sb.append("iexBidPrice");
        sb.append('=');
        sb.append(((this.iexBidPrice == null)?"<null>":this.iexBidPrice));
        sb.append(',');
        sb.append("iexBidSize");
        sb.append('=');
        sb.append(((this.iexBidSize == null)?"<null>":this.iexBidSize));
        sb.append(',');
        sb.append("iexAskPrice");
        sb.append('=');
        sb.append(((this.iexAskPrice == null)?"<null>":this.iexAskPrice));
        sb.append(',');
        sb.append("iexAskSize");
        sb.append('=');
        sb.append(((this.iexAskSize == null)?"<null>":this.iexAskSize));
        sb.append(',');
        sb.append("iexOpen");
        sb.append('=');
        sb.append(((this.iexOpen == null)?"<null>":this.iexOpen));
        sb.append(',');
        sb.append("iexOpenTime");
        sb.append('=');
        sb.append(((this.iexOpenTime == null)?"<null>":this.iexOpenTime));
        sb.append(',');
        sb.append("iexClose");
        sb.append('=');
        sb.append(((this.iexClose == null)?"<null>":this.iexClose));
        sb.append(',');
        sb.append("iexCloseTime");
        sb.append('=');
        sb.append(((this.iexCloseTime == null)?"<null>":this.iexCloseTime));
        sb.append(',');
        sb.append("marketCap");
        sb.append('=');
        sb.append(((this.marketCap == null)?"<null>":this.marketCap));
        sb.append(',');
        sb.append("peRatio");
        sb.append('=');
        sb.append(((this.peRatio == null)?"<null>":this.peRatio));
        sb.append(',');
        sb.append("week52High");
        sb.append('=');
        sb.append(((this.week52High == null)?"<null>":this.week52High));
        sb.append(',');
        sb.append("week52Low");
        sb.append('=');
        sb.append(((this.week52Low == null)?"<null>":this.week52Low));
        sb.append(',');
        sb.append("ytdChange");
        sb.append('=');
        sb.append(((this.ytdChange == null)?"<null>":this.ytdChange));
        sb.append(',');
        sb.append("lastTradeTime");
        sb.append('=');
        sb.append(((this.lastTradeTime == null)?"<null>":this.lastTradeTime));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("isUSMarketOpen");
        sb.append('=');
        sb.append(((this.isUSMarketOpen == null)?"<null>":this.isUSMarketOpen));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}