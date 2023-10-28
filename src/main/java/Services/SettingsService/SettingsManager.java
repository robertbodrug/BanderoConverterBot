package Services.SettingsService;

public class SettingsManager {
    //додати функцію зміни налаштувань

    private Settings settings = new Settings();

    public Settings getSettings() {
        return settings;
    }

    public void setDecimalPlaces(int places){
        settings.setDecimalPlaces(places);
    }
    public void setLanguages(String language){settings.setLanguage(language);}
    public void addBanks(String bank) {settings.addBanks(bank);}
    public void addCurrencies(String currency) {settings.addCurrencies(currency);}
    public void setTime(String time) {settings.setTime(time);}
    public String getTime() {return settings.getTime();}
}
