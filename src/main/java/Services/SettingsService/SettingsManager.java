package Services.SettingsService;

import java.io.IOException;
import java.util.Set;

public class SettingsManager {
    //додати функцію зміни налаштувань

    public static Settings getSettings(long chatId) throws IOException {
        return SettingsReader.getSettings(chatId);
    }

    public static void setDecimalPlaces(int places,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        s.setDecimalPlaces(places);
        SettingsSaver.SaveSettings(chatId,s);
    }
    public static void setLanguages(String language,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        s.setLanguage(language);
        SettingsSaver.SaveSettings(chatId,s);
    }
    public static void addBanks(String bank,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        Set<String> banks = s.getBanks();
        if(banks.contains(bank)) {
            banks.remove(bank);
    } else {
            banks.add(bank);
    }
        s.setBanks(banks);
        SettingsSaver.SaveSettings(chatId,s);
    }
    public static void addCurrencies(String currency,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        Set<String> currencies = s.getCurrencies();
        if(currencies.contains(currency)) {
            currencies.remove(currency);
    }else {
            currencies.add(currency);
        }
        s.setCurrencies(currencies);
            SettingsSaver.SaveSettings(chatId,s);
    }
    public static void addTimeForNotification(String time,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        Set<String> timeForNotification = s.getTimeForNotification();
        if(timeForNotification.contains(time)) {
            timeForNotification.remove(time);
        }else {
            timeForNotification.add(time);
        }
        s.setTimeForNotification(timeForNotification);
            SettingsSaver.SaveSettings(chatId,s);

    }
}
