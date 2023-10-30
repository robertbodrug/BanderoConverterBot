package org.example;

import Services.MessageService.MessageManager;
import Services.SettingsService.Settings;
import Services.SettingsService.SettingsManager;
import Services.SettingsService.SettingsReader;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;



public class BanderoConverterBot extends TelegramLongPollingBot {



    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message msg = update.getMessage();
            if (msg.isCommand()) {
                try {
                    ComandResponser(msg);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
            else {
                try {
                    execute(MessageManager.MessageBuilder(msg.getChatId(), "culo", SettingsManager.getSettings(msg.getChatId())));
                } catch (Exception e) {
                    throw new RuntimeException(e);

                }
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery cq = update.getCallbackQuery();
            try {
                System.out.println(cq.getData());
                CallbackResponser(cq);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        }


    private void ComandResponser(Message msg) throws TelegramApiException, IOException {
       execute(MessageManager.MessageBuilder(msg.getChatId(),msg.getText().replace("/",""), SettingsManager.getSettings(msg.getChatId())));
    }
    private void CallbackResponser(CallbackQuery cq) throws TelegramApiException, IOException {

        String text = cq.getData();
        Long id = cq.getMessage().getChatId();
        Integer msgId = cq.getMessage().getMessageId();
        AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                .callbackQueryId(cq.getId()).build();
        execute(close);
         switch (text) {
             //добавити метод SM і виконати Message
             case "settings","decimal_places","languages","banks","currency","notification","back" -> execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            case "privat", "mono", "nbu" -> {
                SettingsManager.addBanks(text,id);
                execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            }
            case "0","1","2","3","4"-> {
                 SettingsManager.setDecimalPlaces(Integer.parseInt(text),id);
                 execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            }
            case "uk","en","it" ->{
                SettingsManager.setLanguages(text,id);
                execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            }
             case "USD", "EUR" -> {
                 SettingsManager.addCurrencies(text,id);
                 execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
             }
            case "number_0","number_1","number_2",
                    "number_3", "number_4","number_5","number_6",
                    "number_7", "number_8","number_9" -> {
                SettingsManager.setTime(text.substring(7) + (Setting.getTime().length() == 1 ? ":" : ""));
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            }
            case "on","delete","off" -> {
                if (text.equals("delete")) {
                    SettingsManager.getSettings(id).deleteDigitFromTime();
                } else {
                    SettingsManager.setTime("0");
                }
                execute(MessageManager.MessageTextEditer(id, text, msgId, s));
            }
                default -> execute(MessageManager.MessageBuilder(id, text, SettingsReader.getSettings(id)));
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
