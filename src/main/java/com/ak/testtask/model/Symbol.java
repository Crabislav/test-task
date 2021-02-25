package com.ak.testtask.model;

import javax.persistence.*;

@Entity
@Table(name = "symbols")
public class Symbol {

    @Id
    @SequenceGenerator(name = "symbols_id_seq", sequenceName = "symbols_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "symbols_id_seq")
    private long id;

    @Column(name = "symbol")
    private String symbol;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "primary_exchange")
    private String primaryExchange;
    @Column(name = "calculation_price")
    private String calculationPrice;
    @Column(name = "open")
    private Double open;
    @Column(name = "open_time")
    private Long openTime;
    @Column(name = "open_source")
    private String openSource;
    @Column(name = "close")
    private Double close;
    @Column(name = "close_time")
    private Long closeTime;
    @Column(name = "close_source")
    private String closeSource;
    @Column(name = "high")
    private Double high;
    @Column(name = "high_time")
    private Double highTime;
    @Column(name = "high_source")
    private String highSource;
    @Column(name = "low")
    private Double low;
    @Column(name = "low_time")
    private Long lowTime;
    @Column(name = "low_source")
    private String lowSource;
    @Column(name = "latest_price")
    private Double latestPrice;
    @Column(name = "latest_source")
    private String latestSource;
    @Column(name = "latest_time")
    private String latestTime;
    @Column(name = "latest_update")
    private Long latestUpdate;
    @Column(name = "latest_volume")
    private Long latestVolume;
    @Column(name = "iex_realtime_price")
    private Double iexRealtimePrice;
    @Column(name = "iex_realtime_size")
    private Long iexRealtimeSize;
    @Column(name = "iex_last_updated")
    private Long iexLastUpdated;
    @Column(name = "delayed_price")
    private Double delayedPrice;
    @Column(name = "delayed_price_time")
    private Long delayedPriceTime;
    @Column(name = "odd_lot_delayed_price")
    private Double oddLotDelayedPrice;
    @Column(name = "odd_lot_delayed_price_time")
    private Long oddLotDelayedPriceTime;
    @Column(name = "extended_price")
    private Double extendedPrice;
    @Column(name = "extended_change")
    private Double extendedChange;
    @Column(name = "extended_change_percent")
    private Double extendedChangePercent;
    @Column(name = "extended_price_time")
    private Long extendedPriceTime;
    @Column(name = "previous_close")
    private Double previousClose;
    @Column(name = "previous_volume")
    private Long previousVolume;
    @Column(name = "change")
    private Double change;
    @Column(name = "change_percent")
    private Double changePercent;
    @Column(name = "volume")
    private Double volume;
    @Column(name = "iex_market_percent")
    private Double iexMarketPercent;
    @Column(name = "iex_volume")
    private Long iexVolume;
    @Column(name = "avg_total_volume")
    private Long avgTotalVolume;
    @Column(name = "iex_bid_price")
    private Double iexBidPrice;
    @Column(name = "iex_bid_size")
    private Long iexBidSize;
    @Column(name = "iex_ask_price")
    private Double iexAskPrice;
    @Column(name = "iex_ask_size")
    private Long iexAskSize;
    @Column(name = "iex_open")
    private Double iexOpen;
    @Column(name = "iex_open_time")
    private Long iexOpenTime;
    @Column(name = "iex_close")
    private Double iexClose;
    @Column(name = "iex_close_time")
    private Long iexCloseTime;
    @Column(name = "market_cap")
    private Long marketCap;
    @Column(name = "pe_ratio")
    private Double peRatio;
    @Column(name = "week_52_high")
    private Double week52High;
    @Column(name = "week_52_low")
    private Double week52Low;
    @Column(name = "ytd_change")
    private Double ytdChange;
    @Column(name = "last_trade_time")
    private Long lastTradeTime;
    @Column(name = "is_us_market_open")
    private boolean isUSMarketOpen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public String getOpenSource() {
        return openSource;
    }

    public void setOpenSource(String openSource) {
        this.openSource = openSource;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseSource() {
        return closeSource;
    }

    public void setCloseSource(String closeSource) {
        this.closeSource = closeSource;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getHighTime() {
        return highTime;
    }

    public void setHighTime(Double highTime) {
        this.highTime = highTime;
    }

    public String getHighSource() {
        return highSource;
    }

    public void setHighSource(String highSource) {
        this.highSource = highSource;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Long getLowTime() {
        return lowTime;
    }

    public void setLowTime(Long lowTime) {
        this.lowTime = lowTime;
    }

    public String getLowSource() {
        return lowSource;
    }

    public void setLowSource(String lowSource) {
        this.lowSource = lowSource;
    }

    public Double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(Double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public Long getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(Long latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public Long getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(Long latestVolume) {
        this.latestVolume = latestVolume;
    }

    public Double getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public void setIexRealtimePrice(Double iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
    }

    public Long getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public void setIexRealtimeSize(Long iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
    }

    public Long getIexLastUpdated() {
        return iexLastUpdated;
    }

    public void setIexLastUpdated(Long iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    public Double getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(Double delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public Long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(Long delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public Double getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    public void setOddLotDelayedPrice(Double oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
    }

    public Long getOddLotDelayedPriceTime() {
        return oddLotDelayedPriceTime;
    }

    public void setOddLotDelayedPriceTime(Long oddLotDelayedPriceTime) {
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
    }

    public Double getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(Double extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public Double getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(Double extendedChange) {
        this.extendedChange = extendedChange;
    }

    public Double getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(Double extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public Long getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(Long extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }

    public Long getPreviousVolume() {
        return previousVolume;
    }

    public void setPreviousVolume(Long previousVolume) {
        this.previousVolume = previousVolume;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getIexMarketPercent() {
        return iexMarketPercent;
    }

    public void setIexMarketPercent(Double iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    public Long getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(Long iexVolume) {
        this.iexVolume = iexVolume;
    }

    public Long getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(Long avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public Double getIexBidPrice() {
        return iexBidPrice;
    }

    public void setIexBidPrice(Double iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    public Long getIexBidSize() {
        return iexBidSize;
    }

    public void setIexBidSize(Long iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    public Double getIexAskPrice() {
        return iexAskPrice;
    }

    public void setIexAskPrice(Double iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    public Long getIexAskSize() {
        return iexAskSize;
    }

    public void setIexAskSize(Long iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    public Double getIexOpen() {
        return iexOpen;
    }

    public void setIexOpen(Double iexOpen) {
        this.iexOpen = iexOpen;
    }

    public Long getIexOpenTime() {
        return iexOpenTime;
    }

    public void setIexOpenTime(Long iexOpenTime) {
        this.iexOpenTime = iexOpenTime;
    }

    public Double getIexClose() {
        return iexClose;
    }

    public void setIexClose(Double iexClose) {
        this.iexClose = iexClose;
    }

    public Long getIexCloseTime() {
        return iexCloseTime;
    }

    public void setIexCloseTime(Long iexCloseTime) {
        this.iexCloseTime = iexCloseTime;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Double peRatio) {
        this.peRatio = peRatio;
    }

    public Double getWeek52High() {
        return week52High;
    }

    public void setWeek52High(Double week52High) {
        this.week52High = week52High;
    }

    public Double getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(Double week52Low) {
        this.week52Low = week52Low;
    }

    public Double getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(Double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public Long getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(Long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public boolean isUSMarketOpen() {
        return isUSMarketOpen;
    }

    public void setUSMarketOpen(boolean USMarketOpen) {
        isUSMarketOpen = USMarketOpen;
    }

    @Override
    public String toString() {
        return "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", primaryExchange='" + primaryExchange + '\'' +
                ", calculationPrice='" + calculationPrice + '\'' +
                ", open=" + open +
                ", openTime=" + openTime +
                ", openSource='" + openSource + '\'' +
                ", close=" + close +
                ", closeTime=" + closeTime +
                ", closeSource='" + closeSource + '\'' +
                ", high=" + high +
                ", highTime=" + highTime +
                ", highSource='" + highSource + '\'' +
                ", low=" + low +
                ", lowTime=" + lowTime +
                ", lowSource='" + lowSource + '\'' +
                ", latestPrice=" + latestPrice +
                ", latestSource='" + latestSource + '\'' +
                ", latestTime='" + latestTime + '\'' +
                ", latestUpdate=" + latestUpdate +
                ", latestVolume=" + latestVolume +
                ", iexRealtimePrice=" + iexRealtimePrice +
                ", iexRealtimeSize=" + iexRealtimeSize +
                ", iexLastUpdated=" + iexLastUpdated +
                ", delayedPrice=" + delayedPrice +
                ", delayedPriceTime=" + delayedPriceTime +
                ", oddLotDelayedPrice=" + oddLotDelayedPrice +
                ", oddLotDelayedPriceTime=" + oddLotDelayedPriceTime +
                ", extendedPrice=" + extendedPrice +
                ", extendedChange=" + extendedChange +
                ", extendedChangePercent=" + extendedChangePercent +
                ", extendedPriceTime=" + extendedPriceTime +
                ", previousClose=" + previousClose +
                ", previousVolume=" + previousVolume +
                ", change=" + change +
                ", changePercent=" + changePercent +
                ", volume=" + volume +
                ", iexMarketPercent=" + iexMarketPercent +
                ", iexVolume=" + iexVolume +
                ", avgTotalVolume=" + avgTotalVolume +
                ", iexBidPrice=" + iexBidPrice +
                ", iexBidSize=" + iexBidSize +
                ", iexAskPrice=" + iexAskPrice +
                ", iexAskSize=" + iexAskSize +
                ", iexOpen=" + iexOpen +
                ", iexOpenTime=" + iexOpenTime +
                ", iexClose=" + iexClose +
                ", iexCloseTime=" + iexCloseTime +
                ", marketCap=" + marketCap +
                ", peRatio=" + peRatio +
                ", week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", ytdChange=" + ytdChange +
                ", lastTradeTime=" + lastTradeTime +
                ", isUSMarketOpen=" + isUSMarketOpen +
                '}' + "\n";
    }
}