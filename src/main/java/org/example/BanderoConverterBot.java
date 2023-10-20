package org.example;

import Services.KeyboardService.KeyboardManager;
import Services.MessageService.MessageManager;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class BanderoConverterBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            Message msg = update.getMessage();
            String txt = msg.getText();
            Long chatId = msg.getChatId();
            if (msg.isCommand()) {
                switch (txt) {
                    case "/settings": {
                        try {
                            execute(MessageManager.MessageBuilder(chatId, "settings"));
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    case "/languages": {
                        try {
                            execute(MessageManager.MessageBuilder(chatId, "languages"));
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    case "/start": {
                        try {
                            execute(MessageManager.MessageBuilder(chatId, "start"));
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }


                }
            }
//        }else if(update.hasCallbackQuery()){
//            CallbackQuery cq = update.getCallbackQuery();
//            try {
//                buttonTap(cq.getMessage().getChatId(), cq.getId(), cq.getData(),cq.getMessage().getMessageId());
//            } catch (TelegramApiException e) {
//                throw new RuntimeException(e);
//            }
//        }
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
