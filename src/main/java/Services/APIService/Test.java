package Services.APIService;

import java.util.Arrays;

import java.util.Timer;

public class Test {
    public static void main(String[] args) {
        //ExchangeRateManager manager = new ExchangeRateManager();
        ExchangeRate exchangeRate = ExchangeRateManager.getExchangeRate("mono" , "EUR");
<<<<<<< Updated upstream
        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRate = exchangeRates.getMono().get(0);
        System.out.println(exchangeRate.getBank() + exchangeRate.getBuy() + exchangeRate.getCurrencyA());
        exchangeRate = exchangeRates.getPrivat().get(0);
        System.out.println(exchangeRate.getBank() + exchangeRate.getBuy() + exchangeRate.getCurrencyA());
        exchangeRate = exchangeRates.getNbu().get(0);
        System.out.println(exchangeRate.getBank() + exchangeRate.getBuy() + exchangeRate.getCurrencyA());
        //System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getSell() );
        //System.out.println(Arrays.stream("\n=====================\n\n".split("")).count());
=======
        System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getSell() );
>>>>>>> Stashed changes
    }
}
