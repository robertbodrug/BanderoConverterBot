package Services.SettingsService;

import Services.LanguageService.LanguageData;
import Services.LanguageService.Languages;
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
    private StringBuffer times = new StringBuffer();
    public Settings() {
        decimalPlaces = 2;
        banks.add("mono");
        currencies.add("USD");
    }

    public LanguageData getLanguage() {
        return switch (language){
            case "en"-> Languages.englishLanguage;
            case "it"->Languages.italianLanguage;
            default->Languages.ukrainianLanguage;

        };
    }
    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
        return "Settings{" +
                "decimalPlaces=" + decimalPlaces +
                ", language='" + language + '\'' +
                ", banks=" + banks +
                ", currencies=" + currencies +
                ", timeForNotification=" + times +
                '}';
    }
    public void setTime(String in) {
        if(times.length() <= 4) {times.append(in);}
    }
    public String getTime() {
        return times.toString();
    }
    public void deleteDigitFromTime() {
        times.deleteCharAt(getTime().length() - 1);
    }
}
