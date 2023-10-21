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

    public static final InlineKeyboardMarkup DECIMAL_PLACES_KEYBOARD = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("0")
                    .callbackData("0")
                    .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("1")
                    .callbackData("1")
                    .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("2")
                    .callbackData("2")
                    .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("3")
                    .callbackData("3")
                    .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("4")
                    .callbackData("4")
                    .build()))
            .keyboardRow(List.of(InlineKeyboardButton.builder()
                    .text("Назад")
                    .callbackData("settings")
                    .build()))
            .build();
}
