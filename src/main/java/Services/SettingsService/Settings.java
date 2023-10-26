package Services.SettingsService;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

//Класс для зберігання змінних налаштувань
@Getter
public class Settings {
    private int decimalPlaces;
    private LanguageData language = Languages.ukrainianLanguage;
    private Set<String> banks = new HashSet<>();
    private Set<String> currencies = new HashSet<>();
    private Set<String> timeForNotification = new HashSet<>();
    public Settings() {
        decimalPlaces = 2;
        addBanks("nbu");
        addCurrencies("USD");
    }

    public void addBanks(String bank) {
         if(banks.contains(bank)) {
             banks.remove(bank);
         } else {
             banks.add(bank);
         }
    }

    public void addCurrencies(String currency) {
        if(currencies.contains(currency)) {
            currencies.remove(currency);
        }else {
            currencies.add(currency);
        }
    }

    public void addTimeForNotification(String time) {
        timeForNotification.add(time);
    }


    public Settings(byte decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }


}
