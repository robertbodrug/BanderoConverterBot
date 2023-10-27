package Services.MessageService;

import Services.APIService.ExchangeRate;
import Services.APIService.ExchangeRateManager;
import Services.KeyboardService.KeyboardManager;
import Services.SettingsService.LanguageData;
import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class MessageManager {
    public static SendMessage MessageBuilder(Long id, String data, Settings s) throws TelegramApiException {

        return SendMessage.builder()
                .chatId(id)
                .text(getTextForMessage(data, s))
                .replyMarkup(KeyboardManager.KeyboardBuilder(data, s))
                .parseMode("HTML")
                .build();
    }

    public static EditMessageText MessageTextEditer(Long id, String data, int msgId, Settings s) throws TelegramApiException {

        return EditMessageText.builder()
                .chatId(id)
                .messageId(msgId)
                .text(getTextForMessage(data, s))
                .replyMarkup(KeyboardManager.KeyboardBuilder(data, s))
                .parseMode("HTML")
                .build();
    }

    //Додати текст для повідомлення
    public static String getTextForMessage(String data, Settings s) {
        LanguageData language = s.getLanguage();
        return switch (data) {
            case "doJob" -> doJob(s);
            case "settings" -> language.getSettingsMenu().settingsText();
            case "languages", "uk", "en","it" -> language.getLanguageMenu().LanguageText();
            case "banks", "privat", "mono", "nbu" -> language.getBanksMenu().banksText();
            case "decimal_places", "0", "1", "2", "3", "4" -> language.getDecimalPlacesText().formatted(s.getDecimalPlaces());
            case "currency", "USD", "EUR" -> language.getCurrencyMenu().currencyText() + s.getCurrencies();
            case "notification" -> "\nОберіть час на який буде приходити оповіщення: ";
            case "joke" -> {
                String[] jokes = language.getJokes();
                yield jokes[(int) (Math.random() * 56 % jokes.length)];
            }
            default -> language.getStartText();
        };
    }

    private static String doJob(Settings s) {
        String divider= "\n=====================\n\n";
        StringBuilder sb = new StringBuilder();
        for (String bank : s.getBanks()) {
            sb.append(getPrettyBanks(bank, s));
            for (String currency : s.getCurrencies()) {
                ExchangeRate rate = ExchangeRateManager.getExchangeRate(bank,currency);
                sb.append(s.getLanguage().getDoJobText()
                        .formatted(currency,
                                getPrettyRate(rate.getSell(),s),
                                bank.equals("nbu")?"---":getPrettyRate(rate.getBuy(),s)));
            }
            sb.append(divider);
        }
        sb.delete(sb.length()-24,sb.length());
        return sb.toString();
    }

    private static String getPrettyBanks(String bank, Settings s) {
        return switch (bank) {
            case "privat" -> s.getLanguage().getBanksMenu().privatBankButton() + " ⬇\n";
            case "mono" -> s.getLanguage().getBanksMenu().monoBankButton() + "⬇\n";
            case "nbu" -> s.getLanguage().getBanksMenu().nbuBankButton() + "⬇\n";
            default -> throw new IllegalStateException("Unexpected value: " + bank);
        };
    }

    private static String getPrettyRate(String rate, Settings s) {
        return rate.substring(0, rate.indexOf(".") +s.getDecimalPlaces() + (s.getDecimalPlaces()==0?0 :1 ));
    }
}

