package Services.SettingsService;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//Класс для зберігання змінних налаштувань
@Getter
@Setter
public class Settings {
    private int decimalPlaces;
    private String language = "uk";
    private Set<String> banks = new HashSet<>();
    private Set<String> currencies = new HashSet<>();
    private StringBuffer time = new StringBuffer();
    public Settings() {
        decimalPlaces = 2;
        addBanks("mono");
        addCurrencies("USD");
    }

    public LanguageData getLanguage() {
        return switch (language){
            case "en"->Languages.englishLanguage;
            case "it"->Languages.italianLanguage;
            default->Languages.ukrainianLanguage;

        };
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
    public void setTime(String in) {
        if(time.length() <= 4) {time.append(in);}
    }
    public String getTime() {
        return time.toString();
    }
    public void deleteDigitFromTime() {
        time.deleteCharAt(getTime().length() - 1);
    }
}
