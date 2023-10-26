package Services.KeyboardService;

import Services.SettingsService.LanguageData;
import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public enum Keyboards {
    //Додати клавіатуру і перевизначити getKeyboard
    MAIN_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            return super.getKeyboard(s);
        }
    },
    BUSINESS_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData language = s.getLanguage();
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getDoJobButton())
                            .callbackData("doJob")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getSettingsMenu().settingsButton())
                            .callbackData("settings")
                            .build()))
                    .build();

        }
    },
    LANGUAGES_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData language = s.getLanguage().getLanguageMenu();
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("").callbackData("uk")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text().callbackData("en")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Назад")
                            .callbackData("back")
                            .build()))
                    .build();
        }
    },
    SETTINGS_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData.SettingsMenu language = s.getLanguage().getSettingsMenu();
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.decimalPlacesButton())
                            .callbackData("decimal_places")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.banksButton())
                            .callbackData("banks")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.currencyButton())
                            .callbackData("currency")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.notificationButton())
                            .callbackData("notification")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.languagesButton())
                            .callbackData("languages")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getBackButton())
                            .callbackData("back")
                            .build()))
                    .build();
        }
    },
    DECIMAL_PLACES_KEYBOARD {

        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData language = s.getLanguage();
             InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();
                int i = 0;
                while (i < 5) {
                    builder.keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(i + (i == s.getDecimalPlaces() ? "✅" : ""))
                            .callbackData(String.valueOf(i))
                            .build()));
                    i++;
                }
                return   builder.keyboardRow(List.of(InlineKeyboardButton.builder()
                                .text(language.getBackButton())
                                .callbackData("back")
                                .build()))
                        .build();

        }
    },
    BANKS_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData.BanksMenu language = s.getLanguage().getBanksMenu();
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.firstBankButton())
                            .callbackData("privat")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.secondBankButton())
                            .callbackData("mono")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.thirdBankButton())
                            .callbackData("nbu")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getBackButton())
                            .callbackData("back")
                            .build()))
                    .build();
        }
    },
    CURRENCY_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData.CurrencyMenu language = s.getLanguage().getCurrencyMenu();

            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.firstCurrencyButton())
                            .callbackData("USD")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.secondCurrencyButton())
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getBackButton())
                            .callbackData("back")
                            .build()))
                    .build();
        }
    };
    public InlineKeyboardMarkup getKeyboard(Settings s ){
        LanguageData language = s.getLanguage();
        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(InlineKeyboardButton.builder()
                        .text(language.getDoJobButton()).callbackData("doJob")
                        .build()))
                .keyboardRow(List.of(InlineKeyboardButton.builder()
                        .text(language.getSettingsMenu().settingsButton())
                        .callbackData("settings")
                        .build(),InlineKeyboardButton.builder()
                        .text(s.getLanguage().getJokeButton()).callbackData("joke")
                        .build()))

                .build();
    }
}
