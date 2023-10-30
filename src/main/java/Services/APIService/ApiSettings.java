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
                        "https://bank.gov.ua/NBU_Exchange/exchange?json";
        currencyAKeyForJson = bank.equals("privat") ? "ccy" : bank.equals("mono") ? "currencyCodeA" : "CurrencyCode";
        currencyBKeyForJson = bank.equals("privat") ? "base_ccy" : bank.equals("mono") ? "currencyCodeB" : null;

        buyKeyForJson = bank.equals("privat") ? "buy" : bank.equals("mono") ? "rateBuy" : "Amount";
        sellKeyForJson = bank.equals("privat") ? "sale" : bank.equals("mono") ? "rateSell" : null;
        currencyB = bank.equals("privat") ? "UAH" : getBank().equals("nbu") ? null :"980";
    }


    public void setCurrencyA(String currencyA) {
        switch (currencyA) {
            case "USD" -> this.currencyA = getBank().equals("privat") ? currencyA : "840";
            case "EUR" -> this.currencyA = getBank().equals("privat") ? currencyA : "978";
            case "JPY" -> this.currencyA = getBank().equals("privat") ? null : "392";
            case "PLN" -> this.currencyA = getBank().equals("privat") ? null : "985";
            case "CZK" -> this.currencyA = getBank().equals("privat") ? null : "203";
            case "DKK" -> this.currencyA = getBank().equals("privat") ? null : "208";
            case "NOK" -> this.currencyA = getBank().equals("privat") ? null : "578";
            case "SEK" -> this.currencyA = getBank().equals("privat") ? null : "752";
            default -> this.currencyA = getBank().equals("privat") ? null : "484";
        }
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
