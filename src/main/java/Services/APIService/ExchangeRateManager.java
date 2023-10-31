package Services.APIService;

import java.util.List;

public class ExchangeRateManager {
    static ExchangeRates exchangeRates = new ExchangeRates();
    public static ExchangeRate getExchangeRate(String bank, String currency) {
        ExchangeRate exchangeRateResult = new ExchangeRate();
        List<ExchangeRate> allExchangeRates = bank.equals("privat") ? exchangeRates.getPrivat() :
                                                  bank.equals("mono") ? exchangeRates.getMono() :
                                                                         exchangeRates.getNbu();
        for (ExchangeRate exchangeRate : allExchangeRates) {
            if (exchangeRate.getCurrencyA().equals(currency)) {
                exchangeRateResult = exchangeRate;
            }
        }
        return exchangeRateResult;
    }
}
