package Services.SettingsService;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Languages {
    public static final LanguageData ukrainianLanguage = new LanguageData(
            "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!",
            "Отримати курс",
            "Жарт",
            new LanguageData.SettingsMenu("⚙  ---  МЕНЮ НАЛАШТУВАНЬ  ---  ⚙",
                    "Налаштування",
                    "Банки",
                    "Кількість знаків після коми",
                    "Валюти",
                    "Налаштування сповіщень",
                    "Вибір мови",
                    "Назад"),
            new LanguageData.BanksMenu("Обрані банки: \n",
                    "Приват Банк",
                    "Монобанк",
                    "Національний банк України"),
            new LanguageData.CurrencyMenu("Обрані валюти: \n",
                    "Долар США",
                     "Євро",
                    "Песо"));

}
