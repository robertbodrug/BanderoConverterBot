package Services.APIService;

import java.util.List;

public class ExchangeRateManager {
    ExchangeRates exchangeRates = new ExchangeRates();
    ExchangeRate exchangeRateResult = new ExchangeRate();
    public ExchangeRate getExchangeRate(String bank, String currency) {
        List<ExchangeRate> allExchangeRates = bank.equals("privat") ? exchangeRates.getPrivat() :
                                                  bank.equals("mono") ? exchangeRates.getMono() :
                                                                         exchangeRates.getNbu();
        for (ExchangeRate exchangeRate : allExchangeRates) {
            if (exchangeRate.getCurrencyA().equals(currency)) {
                exchangeRateResult.setBank(bank);
                exchangeRateResult.setBuy(exchangeRate.getBuy());
                exchangeRateResult.setCurrencyA(currency);
                exchangeRateResult.setSell(exchangeRate.getSell());
            }
        }
        return exchangeRateResult;
    }
}
