package Services.MessageService;

import Services.KeyboardService.KeyboardManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MessageManager {
    public static SendMessage MessageBuilder(Long id, String data) throws TelegramApiException {

       SendMessage newSm = SendMessage.builder()
               .chatId(id)
               .text(getTextForMessage(data))
               .build();
           newSm.setReplyMarkup(KeyboardManager.KeyboardBuilder(data));
       return newSm;
    }
    public static EditMessageText MessageTextEditer(Long id, String data,int msgId) throws TelegramApiException {

        EditMessageText newSm = EditMessageText.builder()
                .chatId(id)
                .messageId(msgId)
                .text(getTextForMessage(data))
                .build();
        newSm.setReplyMarkup(KeyboardManager.KeyboardBuilder(data));

        return newSm;
    }

public static String getTextForMessage(String data){
    switch (data){
        case "settings" : {
            return "Налаштування";
        }
        case "languages" : {
            return "Виберіть мову: ";
        }
        case "doJob" : {
            return "Курс: logic";
        }
        default:return "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!";
}
}


}

