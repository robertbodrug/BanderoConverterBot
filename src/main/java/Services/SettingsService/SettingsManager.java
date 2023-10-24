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

}
