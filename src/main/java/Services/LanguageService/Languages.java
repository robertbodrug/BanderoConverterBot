package Services.LanguageService;

import Services.LanguageService.LanguageData;

public class Languages {
    public static final LanguageData ukrainianLanguage = new LanguageData(
            "Вітаємо вас у БандероКонвертері. Цей бот створений для слідкування за курсом валют!",
            "Кількість знаків після коми : <b>%d</b> \nОберіть потрібну кількість : ",
            "______________________\n<b>UAH/%s</b> \nКупівля : %s \nПродажа : %s\n",
            "Отримати курс",
            "Жарт",
            "Назад",
             new String[]{"Чому плюшевий ведмедик відмовився від десерту? Він був вже повний.",
                    "Чому футболіст так довго обідав? Тому що він думав, що не може користуватися руками.",
                    "У мами Сенді четверо дітей; Північ, Захід, Схід. Як звуть четверту дитину? Сенді, очевидно!",
                    "Чому курка перебігла майданчик? Щоб добігти до наступної дороги.",
                    "Чому ви ніколи не можете розповісти анекдот про скло? Ви можете луснути."
            },

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

    public static final LanguageData englishLanguage = new LanguageData(
            "Welcome to BanderoConverter. This bot is designed to track currency rates!",
            "Number of decimal places : <b>%d</b> \nChoose the required number : ",
            "______________________\n<b>UAH/%s</b> \nBuy : %s \nSell: %s\n",
            "Get Course",
            "Joke",
            "Back",
            new String[]{"Why did the teddy bear say no to dessert? Because she was stuffed.",
                    "Why did the soccer player take so long to eat dinner? Because he thought he couldn’t use his hands...",
                    "Sandy’s mum has four kids; North, West, East. What is the name of the fourth child? Sandy, obviously!",
                    "Why did the chicken cross the playground? To get to the other slide.",
                    "Why can’t you ever tell a joke around glass? It could crack up."
            },

            new LanguageData.SettingsMenu("⚙ --- SETTINGS MENU --- ⚙",
                    "Settings",
                    "Banks",
                    "Number of decimal places",
                    "Currencies",
                    "Notification settings",
                    "Language selection"
            ),
            new LanguageData.BanksMenu("Selected banks: \n",
                    "Privat Bank",
                    "Monobank",
                    "National Bank of Ukraine")
            ,
            new LanguageData.CurrencyMenu("Selected currencies: \n",
                    "U.S.A. Dollar",
                    "Euro",
                    "Peso"),
            new LanguageData.LanguageMenu("Choose a language: ")
    );
    public static final LanguageData italianLanguage = new LanguageData("Benvenuti in BanderoConverter. Questo bot è progettato per tenere traccia dei tassi di cambio!",
            "Numero di cifre decimali: <b>%d</b> \nScegli il numero richiesto: ",
            "______________________\n<b>UAH/%s</b> \nAcquisto : %s \nVendi: %s\n",
            "Ottieni corso",
            "Scherzo",
            "Indietro",
            new String[]{"Perché l'orsacchiotto ha rifiutato il desserto? Era già pieno.",
                    "Perché il giocatore di calcio ha impiegato così tanto tempo per pranzare? Perché pensava di non poter usare le mani.",
                    "La mamma di Sandy ha quattro figli: Nord, Ovest, Est. Come si chiama il quarto figlio? Sandy, ovviamente!",
                    "Perché la gallina ha attraversato di corsa il cortile? Per correre verso la strada successiva.",
                    "Perché non riesci mai a raccontare una barzelletta sul vetro? Puoi romperlo."
            },

            new LanguageData.SettingsMenu("⚙ --- MENU IMPOSTAZIONI --- ⚙",
                    "Impostazioni",
                    "Banche",
                    "Numero di cifre decimali",
                    "Valute",
                    "Impostazioni di notifica",
                    "Selezione della lingua"
            ),
            new LanguageData.BanksMenu("Banche selezionate: \n",
                    "Banca privata",
                    "Monobanca",
                    "Banca Nazionale dell'Ucraina")
            ,
            new LanguageData.CurrencyMenu("Valute selezionate: \n",
                    "Dollaro Americano",
                    "Euro",
                    "Peso"),
            new LanguageData.LanguageMenu("Scegli una lingua: ")
    );

}
