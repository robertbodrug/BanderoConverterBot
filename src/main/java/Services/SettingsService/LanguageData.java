package Services.SettingsService;

public class LanguageData {
     public static class SettingsMenu {
        private final String settingsText;
        private final String settingsButton;
        private final String banksButton;
        private final String decimalPlacesButton;
        private final String currencyButton;
        private final String notificationButton;
        private final String languagesButton;
        private final String backButton;

        public SettingsMenu(String settingsText, String settingsButton, String banksButton, String decimalPlacesButton, String currencyButton, String notificationButton, String languagesButton, String backButton) {
            this.settingsText = settingsText;
            this.settingsButton = settingsButton;
            this.banksButton = banksButton;
            this.decimalPlacesButton = decimalPlacesButton;
            this.currencyButton = currencyButton;
            this.notificationButton = notificationButton;
            this.languagesButton = languagesButton;
            this.backButton = backButton;
        }
        public String getSettingsText() {
            return settingsText;
        }

        public String getSettingsButton() {
            return settingsButton;
        }

        public String getBanksButton() {
            return banksButton;
        }

        public String getDecimalPlacesButton() {
            return decimalPlacesButton;
        }

        public String getCurrencyButton() {
            return currencyButton;
        }

        public String getNotificationButton() {
            return notificationButton;
        }

        public String getLanguagesButton() {
            return languagesButton;
        }

        public String getBackButton() {
            return backButton;
        }



        }
    public static class BanksMenu{
        private final String banksText;
        private final String firstBankButton;
        private final String secondBankButton;
        private final String thirdBankButton;

        public BanksMenu(String banksText, String firstBankButton, String secondBankButton, String thirdBankButton) {
            this.banksText = banksText;
            this.firstBankButton = firstBankButton;
            this.secondBankButton = secondBankButton;
            this.thirdBankButton = thirdBankButton;
        }

        public String getBanksText() {
            return banksText;
        }

        public String getFirstBankButton() {
            return firstBankButton;
        }

        public String getSecondBankButton() {
            return secondBankButton;
        }

        public String getThirdBankButton() {
            return thirdBankButton;
        }


    }
    public static class CurrencyMenu{
        private final String  currencyText;
        private final String firstCurrencyButton;
        private final String secondCurrencyButton;
        private final String thirdCurrencyButton;
        public CurrencyMenu(String currencyText, String firstCurrencyButton, String secondCurrencyButton, String thirdCurrencyButton) {
            this.currencyText = currencyText;
            this.firstCurrencyButton = firstCurrencyButton;
            this.secondCurrencyButton = secondCurrencyButton;
            this.thirdCurrencyButton = thirdCurrencyButton;
        }

        public String getCurrencyText() {
            return currencyText;
        }

        public String getFirstCurrencyButton() {
            return firstCurrencyButton;
        }

        public String getSecondCurrencyButton() {
            return secondCurrencyButton;
        }

        public String getThirdCurrencyButton() {
            return thirdCurrencyButton;
        }


    }
    private final String startText;
    private final String doJobButton;
    private final String jokeButton;

    private SettingsMenu settingsMenu;
    private final BanksMenu banksMenu;
    private final CurrencyMenu currencyMenu;


    public String getStartText() {
        return startText;
    }

    public String getDoJobButton() {
        return doJobButton;
    }

    public String getJokeButton() {
        return jokeButton;
    }

    public SettingsMenu getSettingsMenu() {
        return settingsMenu;
    }

    public BanksMenu getBanksMenu() {
        return banksMenu;
    }

    public CurrencyMenu getCurrencyMenu() {
        return currencyMenu;
    }

    public LanguageData(String startText, String doJobButton, String jokeButton, SettingsMenu settingsMenu, BanksMenu banksMenu, CurrencyMenu currencyMenu) {
        this.startText = startText;
        this.doJobButton = doJobButton;
        this.jokeButton = jokeButton;
        this.settingsMenu = settingsMenu;
        this.banksMenu = banksMenu;
        this.currencyMenu = currencyMenu;
    }
}
