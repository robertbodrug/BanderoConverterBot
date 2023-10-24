package Services.SettingsService;

//Класс для зберігання змінних налаштувань
public class Settings {
    private int decimalPlaces;
    private String URL;
    private String token;
    private String bank;
    private String currencyTargetForJson;
    private String currency;
    private String buyTargetForJson;
    private String sellTargetForJson;

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setBank(String bank) {
        this.bank = bank;
        setToken(bank.equals("mono") ? "" : null);
        setURL(bank.equals("privat") ? "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5" :
                                        bank.equals("mono") ? "https://api.monobank.ua/bank/currency" :
                                  "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        setCurrencyTargetForJson(bank.equals("privat") ? "ccy" : bank.equals("mono") ? "currencyCodeA" : "r030");
        setBuyTargetForJson(bank.equals("privat") ? "buy" : bank.equals("mono") ? "rateBuy" : "rate");
        setSellTargetForJson(bank.equals("privat") ? "sale" : bank.equals("mono") ? "rateSell" : null);
    }

    public void setCurrencyTargetForJson(String currencyTargetForJson) {
        this.currencyTargetForJson = currencyTargetForJson;
    }

    public void setCurrency(String currency) {
        this.currency = getBank().equals("privat") ? currency : currency.equals("USD") ? "840" : "978";
    }

    public void setSellTargetForJson(String sell) {
        this.sellTargetForJson = sell;
    }

    public void setBuyTargetForJson(String buyTargetForJson) {
        this.buyTargetForJson = buyTargetForJson;
    }

    public String getURL() {
        return URL;
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


    public Settings() {
        decimalPlaces = 2;
    }
    public Settings(byte decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }


}
