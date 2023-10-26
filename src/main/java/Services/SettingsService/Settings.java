package Services.SettingsService;

import java.util.HashSet;
import java.util.Set;

//Класс для зберігання змінних налаштувань
public class Settings {
    private int decimalPlaces;
    private Set<String> banks = new HashSet<>();
    private Set<String> currencies = new HashSet<>();
    private Set<String> timeForNotification = new HashSet<>();

    public void addBanks(String bank) {
         if(bank.equals("clearBanks")) {
             banks.clear();
         } else {
             banks.add(bank);
         }
    }

    public Set<String> getBanks() {
        return banks;
    }

    public void addCurrencies(String currency) {
        if(currency.equals("clearCurrencies")) {
            currencies.clear();
        }else {
            currencies.add(currency);
        }
    }

    public Set<String> getCurrencies() {
        return currencies;
    }
    public void addTimeForNotification(String time) {
        timeForNotification.add(time);
    }

    public Set<String> getTimeForNotification() {
        return timeForNotification;
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
