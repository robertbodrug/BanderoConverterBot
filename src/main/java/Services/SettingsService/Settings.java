package Services.SettingsService;

//Класс для зберігання змінних налаштувань
public class Settings {

    private LanguageData language = Languages.ukrainianLanguage;

    public LanguageData getLanguage() {
        return language;
    }

    private int decimalPlaces;
    private StringBuilder banks = new StringBuilder();
    private StringBuilder currencies = new StringBuilder();
    public Settings() {

        decimalPlaces = 2;
    }
    public Settings(byte decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void addBanks(String bank) {
         banks.append(" ").append(bank);
    }

    public String getBanks() {
        return banks.toString().trim();
    }

    public void addCurrencies(String currency) {
        currencies.append(" ").append(currency);
    }

    public String getCurrencies() {
        return currencies.toString().trim();
    }



    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }


}
