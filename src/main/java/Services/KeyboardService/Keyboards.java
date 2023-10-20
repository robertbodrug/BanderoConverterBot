package Services.KeyboardService;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Keyboards {

    public static final InlineKeyboardMarkup LANGUAGES_KEYBOARD = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("Українська").callbackData("ukrainian")
                    .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("English").callbackData("english")
                    .build()))
            .build();

    public static final InlineKeyboardMarkup MAIN_KEYBOARD = InlineKeyboardMarkup.builder()
                        .keyboardRow(List.of(InlineKeyboardButton.builder()
                                .text("Отримати курс").callbackData("doJob")
                                .build()))
                        .keyboardRow(List.of(InlineKeyboardButton.builder()
                                .text("Налаштування").callbackData("settings")
                                .build()))
                        .build();

    public static final InlineKeyboardMarkup SETTINGS_KEYBOARD = InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Кількість знаків після коми")
                            .callbackData("decimalp_places")
                            .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Банки")
                            .callbackData("banks")
                            .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Валюти")
                            .callbackData("currency")
                            .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                            .text("Час оповіщень")
                            .callbackData("notification")
                            .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("Мова")
                    .callbackData("languages")
                    .build()))
            .build();
}
