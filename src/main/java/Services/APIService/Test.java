package Services.APIService;


public class Test {
    public static void main(String[] args) {
        ExchangeRates exchangeRates = new ExchangeRates();
        for (ExchangeRate exchangeRate : exchangeRates.getNbu()) {
            System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getBuy());
        }
        for (ExchangeRate exchangeRate : exchangeRates.getMono()) {
            System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getBuy());
        }
        for (ExchangeRate exchangeRate : exchangeRates.getPrivat()) {
            System.out.println(exchangeRate.getBank() + exchangeRate.getCurrencyA() + exchangeRate.getBuy());
        }
    }
}
