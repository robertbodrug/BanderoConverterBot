package Services.APIService;
import Services.SettingsService.Settings;

public class ExchangeRateManeger {
    ExchangeRates exchangeRates = new ExchangeRates();
    StringBuilder builder = new StringBuilder();
    public String getExchangeRates(Settings s) {
        for (String bank : s.getBanks()) {
            if (bank.equals("mono")) {
                for (ExchangeRate exchangeRate : exchangeRates.getMono()) {
                    for (String currency : s.getCurrencies()) {
                        if (exchangeRate.getCurrency().equals(currency)) {
                            String result = "Курс монобанк: \n" +
                                    "Купівля: " +
                                    exchangeRate.getBuy() +
                                    exchangeRate.getCurrency() +
                                    "\nПродаж: " +
                                    exchangeRate.getSell() +
                                    exchangeRate.getCurrency() + "\n";
                            builder.append(result);
                        }
                    }
                }
            } else if (bank.equals("privat")) {
                for (ExchangeRate exchangeRate : exchangeRates.getPrivat()) {
                    for (String currency : s.getCurrencies()) {
                        if (exchangeRate.getCurrency().equals(currency)) {
                            String result = "Курс приват банк: \n" +
                                    "Купівля: " +
                                    exchangeRate.getBuy() +
                                    exchangeRate.getCurrency() +
                                    "\nПродаж: " +
                                    exchangeRate.getSell() +
                                    exchangeRate.getCurrency() + "\n";
                            builder.append(result);
                        }
                    }
                }
            } else {
                for (ExchangeRate exchangeRate : exchangeRates.getNbu()) {
                    for (String currency : s.getCurrencies()) {
                        if (exchangeRate.getCurrency().equals(currency)) {
                            String result = "Курс національного банку України: \n" +
                                    "НБУ: " +
                                    exchangeRate.getBuy() +
                                    exchangeRate.getCurrency() + "\n";
                            builder.append(result);
                        }
                    }
                }
            }
        }
        return builder.toString();
    }
}
