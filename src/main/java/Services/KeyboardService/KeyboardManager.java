package Services.KeyboardService;

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
                .messageId(msgId).build();
        newKb.setReplyMarkup(KeyboardBuilder(data));
        return newKb;
    }
    public static InlineKeyboardMarkup KeyboardBuilder(String data) throws TelegramApiException {

        switch (data){
            case "settings" : return SETTINGS_KEYBOARD;
            case "languages": return LANGUAGES_KEYBOARD;
            default: return MAIN_KEYBOARD;
        }

    }

}
