package org.example;

import Services.APIService.NotificationManager;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


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
                SettingsManager.addTimeForNotification(text.substring(7) + (SettingsReader.getSettings(id).getTime().length() == 1 ? ":" : ""), id);
                execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            }
            case "on" -> {
                SettingsManager.setIsWaitingForNotification(id,true);
                if(notificationTask == null){doNotification(SettingsReader.getSettings(id).getTime(), SettingsReader.getSettings(id), id);}
            }
            case "delete","off" -> {
                if (text.equals("delete")) {
                    SettingsManager.deleteDigitFromTime(id);
                } else {
                    if (notificationTask != null) {
                        notificationTask.cancel();
                        notificationTask = null;
                        System.out.println("Notification task is closed");
                    }
                    SettingsManager.clearTimeAndSetNotificationOff(id);
                }
                execute(MessageManager.MessageTextEditer(id, text, msgId, SettingsReader.getSettings(id)));
            }
                default -> execute(MessageManager.MessageBuilder(id, text, SettingsReader.getSettings(id)));
         };
    }
    private TimerTask notificationTask;
    private final Object lock = new Object();
    private Timer timer = new Timer();
    public void doNotification(String t, Settings s, long id) throws IOException {
        int hours = Integer.parseInt(t.substring(0, 2));
        int minutes = Integer.parseInt(t.substring(3));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date executionTime = getTime(hours, minutes);
        System.out.println("Notification will be made at " + sdf.format(executionTime));
            notificationTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        execute(MessageManager.MessageBuilder(id, "doJob", s));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("The notification was made at " + sdf.format(new Date()));
                    try {
                        if(SettingsReader.getSettings(id).isWaitingForNotification()) {
                            doNotification(t,s,id);
                        }else{
                            notificationTask.cancel();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            timer.schedule(notificationTask, executionTime);
    }
    private Date getTime(int hours, int minutes) {
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


    @Override
    public String getBotUsername() {
        return "bandero_converter_bot";
    }
    @Override
    public String getBotToken() {
        return "6805411508:AAFSxU76lQliK8Qb87xNI0YjrAlZsoNLmE4";
    }
}
