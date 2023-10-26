package Services.APIService;

public class ApiSettings {
    private String url;
    private String token;
    private String bank;
    private String currencyAKeyForJson;
    private String currencyA;
    private String currencyBKeyForJson;
    private String currencyB;
    private String buyKeyForJson;
    private String sellKeyForJson;


    public void setBank(String bank) {
        this.bank = bank;
        token = bank.equals("mono") ? "uWGHpv9nnIfe3EJOv964uy4eM04n00mOdKEwH0Ope5nY" : null;
        url = bank.equals("privat") ? "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11" :
                bank.equals("mono") ? "https://api.monobank.ua/bank/currency" :
                        "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        currencyAKeyForJson = bank.equals("privat") ? "ccy" : bank.equals("mono") ? "currencyCodeA" : "r030";
        currencyBKeyForJson = bank.equals("privat") ? "base_ccy" : bank.equals("mono") ? "currencyCodeB" : null;

        buyKeyForJson = bank.equals("privat") ? "buy" : bank.equals("mono") ? "rateBuy" : "rate";
        sellKeyForJson = bank.equals("privat") ? "sale" : bank.equals("mono") ? "rateSell" : null;
        currencyB = getBank().equals("privat") ? "UAH" : getBank().equals("nbu") ? null :"980";
    }


    public void setCurrencyA(String currencyA) {
        this.currencyA = getBank().equals("privat") ? currencyA : currencyA.equals("USD") ? "840" : "978";
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

    public String getCurrencyAKeyForJson() {
        return currencyAKeyForJson;
    }

    public String getCurrencyA() {
        return currencyA;
    }
    public String getCurrencyBKeyForJson() {
        return currencyBKeyForJson;
    }

    public String getCurrencyB() {
        return currencyB;
    }

    public String getBuyKeyForJson() {
        return buyKeyForJson;
    }

    public String getSellKeyForJson() {
        return sellKeyForJson;
    }

}
