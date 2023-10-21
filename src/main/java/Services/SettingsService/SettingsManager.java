package Services.SettingsService;

public class SettingsManager {
    Settings settings = new Settings();

    public Settings getSettings() {
        return settings;
    }

    public void setDecimalp_places(int places){
        settings.setDecimalPlaces(places);
    }
}
