package Services.KeyboardService;

import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public enum Keyboards {
    //Додати клавіатуру і перевизначити getKeyboard
    MAIN_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
            return super.getKeyboard( data,s);
        }
    },
    LANGUAGES_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Українська 🇺🇦").callbackData("uk")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("English \uD83C\uDDEC\uD83C\uDDE7").callbackData("en")
                            .build()))
                    .build();
        }
    },
    SETTINGS_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Кількість знаків після коми")
                            .callbackData("decimalp_places")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Банки")
                            .callbackData("banks")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Валюти")
                            .callbackData("currency")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Час оповіщень")
                            .callbackData("notification")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Мова")
                            .callbackData("languages")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Назад")
                            .callbackData("culo")
                            .build()))
                    .build();
        }
    },
    DECIMAL_PLACES_KEYBOARD {
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
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
                                .text("Назад")
                                .callbackData("settings")
                                .build()))
                        .build();

        }
    },
    BANKS_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getBanks().contains("privat") ? "Приват банк✅" : "Приват банк")
                            .callbackData("privat")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getBanks().contains("mono") ? "Монобанк✅" : "Монобанк")
                            .callbackData("mono")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getBanks().contains("nbu") ? "Національний банк України✅" : "Національний банк України")
                            .callbackData("nbu")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Назад")
                            .callbackData("settings")
                            .build()))
                    .build();
        }
    },
    CURRENCY_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getCurrencies().contains("USD") ? "Долар США✅" : "Долар США")
                            .callbackData("USD")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getCurrencies().contains("EUR") ? "Євро✅" : "Євро")
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Назад")
                            .callbackData("settings")
                            .build()))
                    .build();
        }
    },
    NOTIFICATION_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(String data,Settings s ) {
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Введіть час у форматі HH:mm")
                            .callbackData("30хв")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("")
                            .callbackData("30хв")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("1год")
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("2год")
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("5год")
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("1год")
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Назад")
                            .callbackData("settings")
                            .build()))
                    .build();
        }
    };
    public InlineKeyboardMarkup getKeyboard(String data,Settings s ){
     return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(InlineKeyboardButton.builder()
                        .text("Отримати курс").callbackData("doJob")
                        .build()))
                .keyboardRow(List.of(InlineKeyboardButton.builder()
                        .text("Налаштування").callbackData("settings")
                        .build(),InlineKeyboardButton.builder()
                        .text("Жарт").callbackData("joke")
                        .build()))

                .build();
    }
}
