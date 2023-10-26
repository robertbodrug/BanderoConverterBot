package Services.MessageService;

import Services.KeyboardService.KeyboardManager;
import Services.SettingsService.LanguageData;
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
//Додати текст для повідомлення
public static String getTextForMessage(String data, Settings s){
    LanguageData language = s.getLanguage();
    return switch (data) {
        case "doJob" -> doJob(s);
        case "settings" -> language.getSettingsMenu().settingsText();
        case "languages","uk","en" -> language.getLanguageMenu().LanguageText();
        case "banks","privat","mono","nbu" -> language.getBanksMenu().banksText() ;
        case "decimal_places","0","1","2","3","4" ->language.getDecimalPlacesText().formatted(s.getDecimalPlaces());
        case "currency","USD","EUR" -> language.getCurrencyMenu().currencyText()+s.getCurrencies();
        case "notification" ->  "\nОберіть час на який буде приходити оповіщення: ";
        case "joke" ->{
            String[] jokes = language.getJokes();
            yield jokes[(int) (Math.random()*56 % jokes.length)];
        }
        default -> "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!";
    };
}
 private static String doJob(Settings s) {

     /*String[] cutRateUSD = PrivatBankAPI.getExchangeRatePrivat("USD");
     cutRateUSD[0]= cutRateUSD[0].substring(0, cutRateUSD[0].indexOf(".")+ s.getDecimalPlaces()+1);
     cutRateUSD[1]= cutRateUSD[1].substring(0, cutRateUSD[1].indexOf(".")+ s.getDecimalPlaces()+1);
     String msgUSD = "Курс: UAH/USD \nКупівля : "+ cutRateUSD[0]+"\nПродажа : "+ cutRateUSD[1]+"\n-----------------------------\n";
     String[] cutRateEUR = PrivatBankAPI.getExchangeRatePrivat("EUR");
     cutRateEUR[0]= cutRateEUR[0].substring(0, cutRateEUR[0].indexOf(".")+ s.getDecimalPlaces()+1);
     cutRateEUR[1]= cutRateEUR[1].substring(0, cutRateEUR[1].indexOf(".")+ s.getDecimalPlaces()+1);
     String msgEUR ="Курс: UAH/EUR \nКупівля : "+ cutRateEUR[0]+"\nПродажа : "+ cutRateEUR[1];
     return msgUSD+msgEUR;
     }
*/
     return "";
 }
}

