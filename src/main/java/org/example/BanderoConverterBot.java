package org.example;

import Services.MessageService.MessageManager;
import Services.SettingsService.Settings;
import Services.SettingsService.SettingsManager;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class BanderoConverterBot extends TelegramLongPollingBot {


 SettingsManager SM = new SettingsManager();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message msg = update.getMessage();
            if (msg.isCommand()) {
                try {
                    ComandResponser(msg);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }
            else {
                try {
                    execute(MessageManager.MessageBuilder(update.getMessage().getChatId(), "culo",SM.getSettings()));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);

                }
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery cq = update.getCallbackQuery();
            try {
                System.out.println(cq.getData());
                CallbackResponser(cq);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        }


    private void ComandResponser(Message msg) throws TelegramApiException {
       execute(MessageManager.MessageBuilder(msg.getChatId(),msg.getText().replace("/",""),SM.getSettings()));
    }
    private void CallbackResponser(CallbackQuery cq) throws TelegramApiException {
        String text = cq.getData();
        Long id = cq.getMessage().getChatId();
        Integer msgId = cq.getMessage().getMessageId();
        Settings s = SM.getSettings();
        AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                .callbackQueryId(cq.getId()).build();
        execute(close);
         switch (text) {
             //добавити метод SM і виконати Message
             case "settings","decimal_places","languages","banks","currency","notification" -> execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            case "privat", "mono", "nbu","clearBanks" -> {
                SM.addBanks(text);
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            }
            case "0","1","2","3","4" -> {
                 SM.setDecimalPlaces(Integer.parseInt(text));
                 execute(MessageManager.MessageTextEditer(id, text, msgId, s));
             }
             case "uk","en","it" ->{
                SM.setLanguages(text);
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
             }
            case "USD", "EUR" -> {
                SM.addCurrencies(text);
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            }
            case "number_0","number_1","number_2",
                    "number_3", "number_4","number_5","number_6",
                    "number_7", "number_8","number_9" -> {
                SM.setTime(text.substring(7) + (SM.getTime().length() == 1 ? ":" : ""));
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            }
            case "on" ->
            case "on","delete","off" -> {
                if (text.equals("delete")) {
                    SM.getSettings().deleteDigitFromTime();
                } else {
                    SM.setTime("0");
                }
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            }
                default -> execute(MessageManager.MessageBuilder(id, text, s));
         };
    }


    @Override
    public String getBotUsername() {
        return "bandero_converter_bot";
    }
    @Override
    public String getBotToken() {
        return "6805411508:AAFSxU76lQliK8Qb87xNI0YjrAlZsoNLmE4";
    }
}
