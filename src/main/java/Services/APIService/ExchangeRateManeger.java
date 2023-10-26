package Services.APIService;
import Services.SettingsService.Settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExchangeRateManeger {
    ExchangeRates exchangeRates = new ExchangeRates();
    StringBuilder builder = new StringBuilder();
    public String getExchangeRates(Settings s) {
        List<ExchangeRate> privat = exchangeRates.getPrivat();
        List<ExchangeRate> mono = exchangeRates.getMono();
        List<ExchangeRate> nbu = exchangeRates.getNbu();
        for (String bank : s.getBanks()) {
            if (bank.equals("mono")) {
                for (ExchangeRate exchangeRate : mono) {
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
                for (ExchangeRate exchangeRate : privat) {
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
                for (ExchangeRate exchangeRate : nbu) {
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
