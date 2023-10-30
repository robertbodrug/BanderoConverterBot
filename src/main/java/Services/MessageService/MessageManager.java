package Services.MessageService;

import Services.APIService.ExchangeRate;
import Services.APIService.ExchangeRateManager;
import Services.KeyboardService.KeyboardManager;
import Services.LanguageService.LanguageData;
import Services.SettingsService.Settings;
import org.example.BanderoConverterBot;
import org.apache.http.cookie.SM;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


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
            case "on" -> notificationManager(s.getTime());
            case "settings" -> language.getSettingsMenu().settingsText();
            case "languages", "uk", "en","it" -> language.getLanguageMenu().LanguageText();
            case "banks", "privat", "mono", "nbu" -> language.getBanksMenu().banksText();
            case "decimal_places", "0", "1", "2", "3", "4" -> language.getDecimalPlacesText().formatted(s.getDecimalPlaces());
            case "currency", "USD", "EUR" -> language.getCurrencyMenu().currencyText() + s.getCurrencies();
            case "notification","number_0","number_1","number_2",
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
        System.out.println("eeeeeeeeeee");
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
    private static Timer timer = new Timer();
    public static String notificationManager(String t) {
        int hours = Integer.parseInt(t.substring(0,2));
        int minutes = Integer.parseInt(t.substring(3));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date executionTime = getTime(hours, minutes);
        System.out.println("Output notification at: " + sdf.format(executionTime));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(sdf.format(new Date()));
            }
        }, executionTime);
        return sdf.toString();
    }
    private static Date getTime(int hours, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date now = new Date();
        if (now.after(calendar.getTime())) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return calendar.getTime();
    }
}

