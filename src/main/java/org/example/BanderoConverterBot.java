package org.example;

import Services.KeyboardService.KeyboardManager;
import Services.MessageService.MessageManager;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class BanderoConverterBot extends TelegramLongPollingBot {


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
                    execute(MessageManager.MessageBuilder(update.getMessage().getChatId(), "jopa"));
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
       execute(MessageManager.MessageBuilder(msg.getChatId(),msg.getText().replace("/","")));
    }
    private void CallbackResponser(CallbackQuery cq) throws TelegramApiException {
        String text = cq.getData();
        Long id = cq.getMessage().getChatId();
        Integer messageId = cq.getMessage().getMessageId();

        AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                .callbackQueryId(cq.getId()).build();
        execute(close);
        switch (text) {
            case "settings", "decimalp_places", "banks", "currency", "notification", "languages": {
                execute(MessageManager.MessageTextEditer(id, text, messageId));
                break;
            }
            default:
                execute(MessageManager.MessageBuilder(id, text));
        }
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
