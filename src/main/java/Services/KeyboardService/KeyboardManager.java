package Services.KeyboardService;

import Services.APIService.PrivatBankAPI;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodSerializable;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static Services.KeyboardService.Keyboards.*;

public class KeyboardManager {
    public static EditMessageReplyMarkup KeyboardEditer(Long id, String data, int msgId) throws TelegramApiException {

        EditMessageReplyMarkup newKb = EditMessageReplyMarkup.builder()
                .chatId(id)
                .messageId(msgId)
                .build();
        newKb.setReplyMarkup(KeyboardBuilder(data));
        return newKb;
    }

    public static InlineKeyboardMarkup KeyboardBuilder(String data) throws TelegramApiException {
        return switch (data) {
            case "settings" -> SETTINGS_KEYBOARD;
            case "languages" -> LANGUAGES_KEYBOARD;
//            case "doJob" -> "Заглушка";
//            case "banks" -> "Заглушка";
//            case "decimalp_places" -> "Заглушка";
//            case "currency" -> "Заглушка";
//            case "notification" -> "Заглушка";
//            case "english" -> "Заглушка";
//            case "ukrainian" -> "Заглушка";

            default -> MAIN_KEYBOARD;


        };
    }
}
