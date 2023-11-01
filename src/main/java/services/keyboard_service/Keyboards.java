package services.keyboard_service;

import services.language_service.LanguageData;
import services.settings_service.Settings;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
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
            LanguageData.LanguageMenu language = s.getLanguage().getLanguageMenu();
            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(LanguageData.LanguageMenu.ukrainianLanguageButton).callbackData("uk")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(LanguageData.LanguageMenu.englishLanguageButton).callbackData("en")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(LanguageData.LanguageMenu.italianLanguageButton).callbackData("it")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getBackButton())
                            .callbackData("settings")
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
                                .callbackData("settings")
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
                            .text(language.privatBankButton() + (s.getBanks().contains("privat") ? "✅" : ""))
                            .callbackData("privat")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.monoBankButton() + (s.getBanks().contains("mono") ? "✅" : ""))
                            .callbackData("mono")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.nbuBankButton() + (s.getBanks().contains("nbu") ? "✅" : ""))
                            .callbackData("nbu")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getBackButton())
                            .callbackData("settings")
                            .build()))
                    .build();
        }
    },
    NOTIFICATION_KEYBOARD {
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s) {
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
            List<InlineKeyboardButton> numberButtons1 = new ArrayList<>();
            for (int i = 0; i <= 4; i++) {
                InlineKeyboardButton button = new InlineKeyboardButton(Integer.toString(i));
                button.setCallbackData("number_" + i);
                numberButtons1.add(button);
            }
            keyboard.add(numberButtons1);
            List<InlineKeyboardButton> numberButtons2 = new ArrayList<>();
            for (int i = 5; i <= 9; i++) {
                InlineKeyboardButton button = new InlineKeyboardButton(Integer.toString(i));
                button.setCallbackData("number_" + i);
                numberButtons2.add(button);
            }
            keyboard.add(numberButtons2);
            List<InlineKeyboardButton> okButton = new ArrayList<>();
            InlineKeyboardButton ok = new InlineKeyboardButton("Ввімкнути");
            ok.setCallbackData("on");
            okButton.add(ok);
            InlineKeyboardButton delete = new InlineKeyboardButton("Видалити");
            delete.setCallbackData("delete");
            okButton.add(delete);
            keyboard.add(okButton);
            List<InlineKeyboardButton> controlButtons = new ArrayList<>();
            InlineKeyboardButton addTime = new InlineKeyboardButton("Вимкнути");
            addTime.setCallbackData("off");
            controlButtons.add(addTime);
            InlineKeyboardButton back = new InlineKeyboardButton("Назад");
            back.setCallbackData("settings");
            controlButtons.add(back);
            keyboard.add(controlButtons);
            InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboard);
            return keyboardMarkup;
        }
    },
    CURRENCY_KEYBOARD{
        @Override
        public InlineKeyboardMarkup getKeyboard(Settings s ) {
            LanguageData.CurrencyMenu language = s.getLanguage().getCurrencyMenu();

            return InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.firstCurrencyButton() + (s.getCurrencies().contains("USD") ? "✅" : ""))
                            .callbackData("USD")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(language.secondCurrencyButton() + (s.getCurrencies().contains("EUR") ? "✅" : ""))
                            .callbackData("EUR")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("JPY" + (s.getCurrencies().contains("JPY") ? "✅" : ""))
                            .callbackData("JPY")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("PLN" + (s.getCurrencies().contains("PLN") ? "✅" : ""))
                            .callbackData("PLN")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("CZK" + (s.getCurrencies().contains("CZK") ? "✅" : ""))
                            .callbackData("CZK")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("DKK" + (s.getCurrencies().contains("DKK") ? "✅" : ""))
                            .callbackData("DKK")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("NOK" + (s.getCurrencies().contains("NOK") ? "✅" : ""))
                            .callbackData("NOK")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("SEK" + (s.getCurrencies().contains("SEK") ? "✅" : ""))
                            .callbackData("SEK")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("MXN" + (s.getCurrencies().contains("MXN") ? "✅" : ""))
                            .callbackData("MXN")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(s.getLanguage().getBackButton())
                            .callbackData("settings")
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
                        .build(),
                        InlineKeyboardButton.builder()
                        .text(s.getLanguage().getJokeButton()).callbackData("joke")
                        .build()))

                .build();
    }
}
