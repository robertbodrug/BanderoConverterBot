package Services.MessageService;

import Services.APIService.PrivatBankAPI;
import Services.KeyboardService.KeyboardManager;
import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class MessageManager {
    public static SendMessage MessageBuilder(Long id, String data,Settings s) throws TelegramApiException {

        return SendMessage.builder()
               .chatId(id)
               .text(getTextForMessage(data,s))
               .replyMarkup(KeyboardManager.KeyboardBuilder(data,s))
               .build();
    }
    public static EditMessageText MessageTextEditer(Long id, String data,int msgId,Settings s) throws TelegramApiException {

        return EditMessageText.builder()
                .chatId(id)
                .messageId(msgId)
                .text(getTextForMessage(data,s))
                .replyMarkup(KeyboardManager.KeyboardBuilder(data,s))
                .build();
    }

public static String getTextForMessage(String data, Settings s){
    return switch (data) {
        case "doJob" -> doJob(s);
        case "settings" -> "НАЛАШТУВАННЯ";
        case "languages" -> "Виберіть мову: ";
        case "banks" -> "Заглушка";
        case "decimalp_places","0","1","2","3","4" -> "Кількість знаків : "+s.getDecimalPlaces()+"\nВиберіть кількість знаків після коми: ";
        case "currency" -> "Заглушка";
        case "notification" -> "Заглушка";
        case "en" -> "Заглушка";
        case "uk" -> "Заглушка";

        default -> "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!";
    };
}
 private static String doJob(Settings s){
     String[] cutRate = PrivatBankAPI.getExchangeRatePrivat("USD");
     cutRate[0]=cutRate[0].substring(0,cutRate[0].indexOf(".")+ s.getDecimalPlaces()+1);
     cutRate[1]=cutRate[1].substring(0,cutRate[1].indexOf(".")+ s.getDecimalPlaces()+1);
     return "Курс: UAH/USD \nКупівля : "+cutRate[0]+"\nПродажа : "+cutRate[1];

 }

}

