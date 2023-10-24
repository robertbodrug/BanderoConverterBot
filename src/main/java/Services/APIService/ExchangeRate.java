package Services.APIService;

public class ExchangeRate {
    private String bank;
    private String currency;
    private String buy;
    private String sell;

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
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
