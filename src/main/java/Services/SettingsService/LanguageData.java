package Services.SettingsService;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LanguageData {
        public record SettingsMenu(String settingsText, String settingsButton, String banksButton,
                                   String decimalPlacesButton, String currencyButton, String notificationButton,
                                   String languagesButton){
        }
        public record BanksMenu(String banksText, String firstBankButton, String secondBankButton,
                                String thirdBankButton) {
        }
        public record CurrencyMenu(String currencyText, String firstCurrencyButton, String secondCurrencyButton,
                                   String thirdCurrencyButton) {
        }
    public record LanguageMenu(String LanguageText) {
        final static String firstLanguageButton = "Українська 🇺🇦";
        final static String secondLanguageButton = "English \uD83C\uDDEC\uD83C\uDDE7";
        ;
        final static String thirdLanguageButton = "Italiano \uD83C\uDDEE\uD83C\uDDF9";
    }

    private final String startText;
    private final String decimalPlacesText;
    private final String doJobButton;
    private final String jokeButton;
    private final String backButton;
    private final String[] jokes;


    private final SettingsMenu settingsMenu;
    private final BanksMenu banksMenu;
    private final CurrencyMenu currencyMenu;
    private final LanguageMenu languageMenu;



}
