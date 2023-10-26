package Services.SettingsService;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.sql.Array;
import java.util.List;

public class Languages {
    public static final LanguageData ukrainianLanguage = new LanguageData(
            "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!",
            "Отримати курс",
            "Жарт",
            "Назад",
            "Кількість знаків після коми : %d \n Оберіть потрібну кількість : ",
            (String[]) List.of("Чому плюшевий ведмедик відмовився від десерту? Він був вже заповнений." +
                    "Чому футболіст так довго обідав? Тому що він думав, що не може користуватися руками.",
                    "У мами Сенді четверо дітей; Північ, Захід, Схід. Як звуть четверту дитину? Сенді, очевидно!",
                    "Чому курка перебігла майданчик? Щоб добігти до наступної дороги.",
                    "Чому ви ніколи не можете розповісти анекдот про скло? Ви можете луснути."
            ).toArray(),

            new LanguageData.SettingsMenu("⚙  ---  МЕНЮ НАЛАШТУВАНЬ  ---  ⚙",
                    "Налаштування",
                    "Банки",
                    "Кількість знаків після коми",
                    "Валюти",
                    "Налаштування сповіщень",
                    "Вибір мови"
                    ),
            new LanguageData.BanksMenu("Обрані банки: \n",
                    "Приват Банк",
                    "Монобанк",
                    "Національний банк України"),
            new LanguageData.CurrencyMenu("Обрані валюти: \n",
                    "Долар США",
                     "Євро",
                    "Песо"),
            new LanguageData.LanguageMenu("Оберіть мову: ")
    );

}
