package org.example;

import Services.MessageService.MessageManager;
import Services.SettingsService.Settings;
import Services.SettingsService.SettingsManager;
import Services.SettingsService.SettingsReader;
import Services.SettingsService.SettingsSaver;
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
            case "privat", "mono", "nbu","clearBanks" -> {
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
            case "USD", "EUR","clearCurrencies" -> {
                SettingsManager.addCurrencies(text,id);
                execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            }
                default ->                 execute(MessageManager.MessageBuilder(id, text, SettingsReader.getSettings(id)));

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
