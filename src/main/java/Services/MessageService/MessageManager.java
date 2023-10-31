package Services.MessageService;

import Services.APIService.ExchangeRate;
import Services.APIService.ExchangeRateManager;
import Services.KeyboardService.KeyboardManager;
import Services.LanguageService.LanguageData;
import Services.SettingsService.Settings;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.*;


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
            case "on" -> getPrettyNotification(s);
            case "settings" -> language.getSettingsMenu().settingsText();
            case "languages", "uk", "en","it" -> language.getLanguageMenu().LanguageText();
            case "banks", "privat", "mono", "nbu" -> language.getBanksMenu().banksText();
            case "decimal_places", "0", "1", "2", "3", "4" -> language.getDecimalPlacesText().formatted(s.getDecimalPlaces());
            case "currency", "USD", "EUR","JPY","PLN","CZK","DKK","NOK","SEK","MXN" -> language.getCurrencyMenu().currencyText() + s.getCurrencies();
            case "notification" -> !s.isWaitingForNotification() ? "\nВведіть час у форматі HH:MM на який буде приходити оповіщення: " + s.getTime() : getPrettyNotification(s);
            case "number_0","number_1","number_2",
                    "number_3", "number_4","number_5","number_6",
                    "number_7", "number_8","number_9",
                    "delete","off" -> "\nВведіть час у форматі HH:MM на який буде приходити оповіщення: " + s.getTime();
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
                                getPrettyRate(rate.getBuy(),s),
                                bank.equals("nbu")?"---":getPrettyRate(rate.getSell(),s)));
            }
            sb.append(divider);
        }
        sb.delete(sb.length()-24,sb.length());
        return sb.toString();
    }
    private static String getPrettyNotification(Settings s) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Ваші налаштування опвіщень:\uD83D\uDD14\n\nЧас, коли оповіщення будуть приходити: ").append(s.getTime()).append("\uD83D\uDD50 \n\nОбрані банки:\n");
        for(String bank : s.getBanks()) {
            stringBuffer.append(getPrettyBanks(bank, s));
        }
        stringBuffer.append("\nОбрані валюти:\n");
        for(String currency : s.getCurrencies()) {
            stringBuffer.append(currency).append("\n");
        }
        return stringBuffer.toString();
    }

    private static String getPrettyBanks(String bank, Settings s) {
        return switch (bank) {
            case "privat" -> s.getLanguage().getBanksMenu().privatBankButton() + " ⬇\n";
            case "mono" -> s.getLanguage().getBanksMenu().monoBankButton() + "⬇\n";
            case "nbu" -> s.getLanguage().getBanksMenu().nbuBankButton() + "⬇\n";
            default -> throw new IllegalStateException("Unexpected value: " + bank);
        };
    }

    public static String getPrettyRate(String rate, Settings s) {
        int decimalPlaces = s.getDecimalPlaces();
        int rateLenght = rate.indexOf('.')+1+(decimalPlaces==0?-1:decimalPlaces);
        if(rate.length()<rateLenght){
            return   rate+String.join("", () -> new Iterator<>() {
                int count = 0;

                @Override
                public boolean hasNext() {
                    if (rate.length() + count < rateLenght) {
                        count++;
                        return true;
                    }
                    return false;

                }

                @Override
                public String next() {
                    return "0";
                }
            });
        }
        else {
            return rate.substring(0, rateLenght);
        }
    }
}

