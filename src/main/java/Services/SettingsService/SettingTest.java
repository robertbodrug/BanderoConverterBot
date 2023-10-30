package Services.SettingsService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SettingTest {
    public static void main(String[] args) throws IOException {
        SettingsManager.setDecimalPlaces(3,977830218L);
        SettingsManager.addCurrencies("EUR",977830218L);
        System.out.println(SettingsReader.getSettings(977830218L));
        SettingsManager.addTimeForNotification("---",977830218L);
        SettingsManager.setLanguages("UK",977830218L);
        SettingsManager.addBanks("PRIVAT",977830218L);
        System.out.println(SettingsReader.getSettings(977830218L));
    }
}
