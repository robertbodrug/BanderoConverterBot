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
                            .text(language.getDoJobButton()).callbackData("doJob")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getSettingsMenu().getSettingsButton()).callbackData("settings")
                            .build()))
                    .build();

        }
    },
    LANGUAGES_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData language = s.getLanguage();
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Українська 🇺🇦").callbackData("uk")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("English \uD83C\uDDEC\uD83C\uDDE7").callbackData("en")
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
                            .text(language.getDecimalPlacesButton())
                            .callbackData("decimal_places")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getBanksButton())
                            .callbackData("banks")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getCurrencyButton())
                            .callbackData("currency")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getNotificationButton())
                            .callbackData("notification")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getLanguagesButton())
                            .callbackData("languages")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getBackButton())
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
                                .text(language.getSettingsMenu().getBackButton())
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
                            .text(language.getFirstBankButton())
                            .callbackData("privat")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getSecondBankButton())
                            .callbackData("mono")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getThirdBankButton())
                            .callbackData("nbu")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getSettingsMenu().getBackButton())
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
                            .text(language.getFirstCurrencyButton())
                            .callbackData("USD")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getSecondCurrencyButton())
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.getThirdCurrencyButton())
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
                        .text(language.getSettingsMenu().getSettingsButton()).callbackData("settings")
                        .build(),InlineKeyboardButton.builder()
                        .text(s.getLanguage().getJokeButton()).callbackData("joke")
                        .build()))

                .build();
    }
}
