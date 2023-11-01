package services.settings_service;

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
        SettingsSaver.saveSettings(chatId,s);
    }
    public static void setLanguages(String language,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        s.setLanguage(language);
        SettingsSaver.saveSettings(chatId,s);
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
        SettingsSaver.saveSettings(chatId,s);
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
            SettingsSaver.saveSettings(chatId,s);
    }
    public static void addTimeForNotification(String time,long chatId) throws IOException {
        Settings s = getSettings(chatId);
        s.setTime(time);
        SettingsSaver.saveSettings(chatId,s);
    }
    public static void clearTimeAndSetNotificationOff(long chatId) throws IOException {
        Settings s = getSettings(chatId);
        s.clearTimeAndSetNotificationOff();
        SettingsSaver.saveSettings(chatId,s);
    }
    public static void deleteDigitFromTime(long chatId) throws IOException {
        Settings s = getSettings(chatId);
        s.deleteDigitFromTime();
        SettingsSaver.saveSettings(chatId,s);
    }
    public static void setIsWaitingForNotification(long chatId, boolean isWaiting) throws IOException {
        Settings s = getSettings(chatId);
        s.setWaitingForNotification(isWaiting);
        SettingsSaver.saveSettings(chatId,s);
    }

}
