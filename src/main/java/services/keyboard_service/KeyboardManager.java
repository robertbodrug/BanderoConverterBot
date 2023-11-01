package services.keyboard_service;

import services.settings_service.Settings;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static services.keyboard_service.Keyboards.*;

public class KeyboardManager {
    public static EditMessageReplyMarkup keyboardEditer(Long id, String data, int msgId, Settings s) throws TelegramApiException {

        EditMessageReplyMarkup newKb = EditMessageReplyMarkup.builder()
                .chatId(id)
                .messageId(msgId)
                .build();
        newKb.setReplyMarkup(keyboardBuilder(data,s));
        return newKb;
    }

    public static InlineKeyboardMarkup keyboardBuilder(String data, Settings s) throws TelegramApiException {
        //Додати виклик клавіатури
        return switch (data) {
            case "settings" -> SETTINGS_KEYBOARD.getKeyboard(s);
            case "languages","en","uk","it" -> LANGUAGES_KEYBOARD.getKeyboard(s);
//            case "doJob" -> "Заглушка";
            case "banks","privat","mono","nbu" -> BANKS_KEYBOARD.getKeyboard(s);
            case "decimal_places","0","1","2","3","4"->DECIMAL_PLACES_KEYBOARD.getKeyboard(s);
            case "currency","USD","EUR","JPY","PLN","CZK","DKK","NOK","SEK","MXN" -> CURRENCY_KEYBOARD.getKeyboard(s);
            case "notification","number_0","number_1","number_2",
                    "number_3", "number_4","number_5","number_6",
                    "number_7", "number_8","number_9","on",
                    "delete","off" -> NOTIFICATION_KEYBOARD.getKeyboard(s);
            default -> MAIN_KEYBOARD.getKeyboard(s);


        };

    }


}
