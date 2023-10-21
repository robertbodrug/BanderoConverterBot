package Services.MessageService;

import Services.APIService.PrivatBankAPI;
import Services.KeyboardService.KeyboardManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.math.BigDecimal;
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

        return EditMessageText.builder()
                .chatId(id)
                .messageId(msgId)
                .text(getTextForMessage(data))
                .replyMarkup(KeyboardManager.KeyboardBuilder(data))
                .build();
    }

public static String getTextForMessage(String data){
    return switch (data) {
        case "doJob" -> {
            double[] rate = PrivatBankAPI.getExchangeRatePrivat("USD");
            yield "Курс: UAH/USD \nКупівля : "+rate[0]+"\nПродажа : "+rate[1];
        }
        case "settings" -> "НАЛАШТУВАННЯ";
        case "languages" -> "Виберіть мову: ";
        case "banks" -> "Заглушка";
        case "decimalp_places" -> "Заглушка";
        case "currency" -> "Заглушка";
        case "notification" -> "Заглушка";
        case "english" -> "Заглушка";
        case "ukrainian" -> "Заглушка";

        default -> "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!";
    };
}


}

