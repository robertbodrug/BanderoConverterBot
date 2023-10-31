package doJob;

import Services.APIService.ExchangeRate;
import Services.APIService.ExchangeRateManager;
import Services.APIService.ExchangeRates;
import Services.SettingsService.Settings;

import java.util.Set;

public class JobTest {
    public static void main(String[] args) {
        Settings settings = new Settings();
        //
settings.setCurrencies(Set.of("EUR","USD","JPY","PLN","CZK","DKK","NOK","SEK","MXN"));
settings.setBanks(Set.of("privat","mono","nbu"));
        System.out.println(ExchangeRateManager.getExchangeRate("privat", "JPY").getCurrencyA());
         System.out.println(Prettier.DoJob(settings));

    }
}
