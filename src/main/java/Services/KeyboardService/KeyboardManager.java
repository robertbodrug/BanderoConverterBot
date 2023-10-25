package Services.KeyboardService;

import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        //Додати виклик клавіатури
        return switch (data) {
            case "settings" -> SETTINGS_KEYBOARD.getKeyboard(s);
            case "languages" -> LANGUAGES_KEYBOARD.getKeyboard(s);
            case "doJob" -> BUSINESS_KEYBOARD.getKeyboard(s);
            case "banks","privat","mono","nbu" -> BANKS_KEYBOARD.getKeyboard(s);
            case "decimal_places","0","1","2","3","4"->DECIMAL_PLACES_KEYBOARD.getKeyboard(s);
            case "currency","USD","EUR" -> CURRENCY_KEYBOARD.getKeyboard(s);
//          case "notification" -> "Заглушка";
//          case "en" -> "Заглушка";
//          case "uk" -> "Заглушка";
            default -> MAIN_KEYBOARD.getKeyboard(s);


        };

    }


}
