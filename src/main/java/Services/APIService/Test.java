package Services.APIService;

public class Test {
    public static void main(String[] args) {
        SavingAndUpdateExchangeRates updateExchangeRates = new SavingAndUpdateExchangeRates();
        for (ExchangeRate exchangeRate : updateExchangeRates.getPrivat()) {
            System.out.println(exchangeRate.getBank() + " " + exchangeRate.getCurrency() + " " + exchangeRate.getBuy());
        }
        for (ExchangeRate exchangeRate : updateExchangeRates.getMono()) {
            System.out.println(exchangeRate.getBank() + " " + exchangeRate.getCurrency() + " " +  exchangeRate.getBuy());
        }
        for (ExchangeRate exchangeRate : updateExchangeRates.getNbu()) {
            System.out.println(exchangeRate.getBank() + " " + exchangeRate.getCurrency() + " " + exchangeRate.getBuy());
        }
    }
}
