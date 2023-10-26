package Services.APIService;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //ExchangeRateManager manager = new ExchangeRateManager();
        ExchangeRate exchangeRate = ExchangeRateManager.getExchangeRate("mono" , "EUR");
        System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getSell() );
        System.out.println(Arrays.stream("\n=====================\n\n".split("")).count());
    }
}
