package Services.APIService;

public class Test {
    public static void main(String[] args) {
        ExchangeRateManager manager = new ExchangeRateManager();
        ExchangeRate exchangeRate = manager.getExchangeRate("mono", "EUR");
        System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getSell() + exchangeRate.getBuy());
    }
}
