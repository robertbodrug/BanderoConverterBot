package Services.APIService;

public class ApiSettings {
    private String url;
    private String token;
    private String bank;
    private String currencyTargetForJson;
    private String currency;
    private String buyTargetForJson;
    private String sellTargetForJson;


    public void setBank(String bank) {
        this.bank = bank;
        token = bank.equals("mono") ? "uWGHpv9nnIfe3EJOv964uy4eM04n00mOdKEwH0Ope5nY" : null;
        url = bank.equals("privat") ? "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5" :
                bank.equals("mono") ? "https://api.monobank.ua/bank/currency" :
                        "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        currencyTargetForJson = bank.equals("privat") ? "ccy" : bank.equals("mono") ? "currencyCodeA" : "r030";
        buyTargetForJson = bank.equals("privat") ? "buy" : bank.equals("mono") ? "rateBuy" : "rate";
        sellTargetForJson = bank.equals("privat") ? "sale" : bank.equals("mono") ? "rateSell" : null;
    }


    public void setCurrency(String currency) {
        this.currency = getBank().equals("privat") ? currency : currency.equals("USD") ? "840" : "978";
    }


    public String getURL() {
        return url;
    }

    public String getToken() {
        return token;
    }

    public String getBank() {
        return bank;
    }

    public String getCurrencyTargetForJson() {
        return currencyTargetForJson;
    }

    public String getCurrency() {
        return currency;
    }

    public String getBuyTargetForJson() {
        return buyTargetForJson;
    }

    public String getSellTargetForJson() {
        return sellTargetForJson;
    }

}
