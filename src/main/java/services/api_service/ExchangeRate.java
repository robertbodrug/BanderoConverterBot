package services.api_service;

public class ExchangeRate {
    private String bank;
    private String currencyA;
    private String currencyB;
    private String buy;
    private String sell;

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setCurrencyA(String currencyA) {
        this.currencyA = currencyA;
    }

    public String getCurrencyA() {
        return currencyA;
    }

    public void setCurrencyB(String currencyB) {
        this.currencyB = currencyB;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getBuy() {
        return buy;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getSell() {
        return sell;
    }
}
