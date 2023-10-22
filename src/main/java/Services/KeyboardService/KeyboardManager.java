package Services.KeyboardService;

import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

import static Services.KeyboardService.Keyboards.*;

public class KeyboardManager {
    public static EditMessageReplyMarkup KeyboardEditer(Long id, String data, int msgId,Settings s) throws TelegramApiException {

        EditMessageReplyMarkup newKb = EditMessageReplyMarkup.builder()
                .chatId(id)
                .messageId(msgId)
                .build();
        newKb.setReplyMarkup(KeyboardBuilder(data,s));
        return newKb;
    }

    public static InlineKeyboardMarkup KeyboardBuilder(String data, Settings s) throws TelegramApiException {
        System.out.println("hhhh");
        return switch (data) {
            case "settings" -> getKeyboard(SETTINGS_KEYBOARD,s);
            case "languages" -> getKeyboard(LANGUAGES_KEYBOARD,s);
//            case "doJob" -> "Заглушка";
//            case "banks" -> "Заглушка";
            case "decimalp_places","0","1","2","3","4"->getKeyboard(DECIMAL_PLACES_KEYBOARD,s);
//          case "currency" -> "Заглушка";
//          case "notification" -> "Заглушка";
//          case "en" -> "Заглушка";
//          case "uk" -> "Заглушка";
            default -> getKeyboard(MAIN_KEYBOARD,s);


        };

    }
    public static InlineKeyboardMarkup getKeyboard (Keyboards k, Settings s) {
        return switch (k.name()) {
            case "MAIN_KEYBOARD"->InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Отримати курс").callbackData("doJob")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Налаштування").callbackData("settings")
                            .build()))
                    .build();
            case "DECIMAL_PLACES_KEYBOARD"->{
                InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();
                int i = 0;
                while (i < 5) {
                    builder.keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text(i + (i == s.getDecimalPlaces() ? "✅" : ""))
                            .callbackData(String.valueOf(i))
                            .build()));
                    i++;
                }
                yield  builder.keyboardRow(List.of(InlineKeyboardButton.builder()
                                .text("Назад")
                                .callbackData("settings")
                                .build()))
                        .build();
            }

            case "SETTINGS_KEYBOARD" ->InlineKeyboardMarkup.builder()
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
                    .build();

            case "LANGUAGES_KEYBOARD" -> InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Українська").callbackData("uk")
                            .build()))
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("English").callbackData("en")
                            .build()))
                    .build();

            default->
                throw new IllegalStateException("Unexpected value: " + k.name());
        };
    }

}
