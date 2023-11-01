package doJob;

import services.message_service.DoJobPrettier;
import services.settings_service.Settings;

import java.util.Set;

public class JobTest {
    public static void main(String[] args) {
        Settings settings = new Settings();

settings.setCurrencies(Set.of("USD","EUR","JPY","PLN","CZK","DKK","NOK","SEK","MXN"));
settings.setBanks(Set.of("privat","mono","nbu"));
settings.setDecimalPlaces(3);

        System.out.println(DoJobPrettier.doJob(settings));
        System.out.println(Prettier.getCutRate("0", 10));
        System.out.println(Prettier.getCutRate("541.554", 100));

        System.out.println(Prettier.getCutRate("17.56658787864", 0));

    }
}
