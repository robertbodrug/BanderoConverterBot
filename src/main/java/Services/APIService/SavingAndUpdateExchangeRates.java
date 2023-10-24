package Services.APIService;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class SavingAndUpdateExchangeRates {
    private ApiLogic logic = new ApiLogic();
    private ApiSettings settings;
    private List<ExchangeRate> privat = new ArrayList<>();
    private List<ExchangeRate> mono = new ArrayList<>();
    private List<ExchangeRate> nbu = new ArrayList<>();
    public void update(String bank) {
        String[] currencies = new String[] {"USD", "EUR"};
        settings = new ApiSettings();
        settings.setBank(bank);
            for (JsonElement element : logic.getExchangeRate(settings)) {
                for (String currency : currencies) {
                    settings.setCurrency(currency);
                    JsonObject object = element.getAsJsonObject();
                    if (settings.getBank().equals("privat") ? settings.getCurrency().equals(object.get(settings.getCurrencyTargetForJson()).getAsString()) :
                            Integer.parseInt(settings.getCurrency()) == object.get(settings.getCurrencyTargetForJson()).getAsInt()) {
                        ExchangeRate exchangeRate = new ExchangeRate();
                        exchangeRate.setBank(bank);
                        exchangeRate.setCurrency(object.get(settings.getCurrencyTargetForJson()).getAsString());
                        exchangeRate.setBuy(object.get(settings.getBuyTargetForJson()).getAsString());
                        if (settings.getSellTargetForJson() != null) {
                            exchangeRate.setSell(object.get(settings.getSellTargetForJson()).getAsString());
                        }
                        if(bank.equals("privat")){
                            exchangeRate.setCurrency(currency);
                            privat.add(exchangeRate);
                        } else if(bank.equals("mono")) {
                            exchangeRate.setCurrency(currency);
                            mono.add(exchangeRate);
                        } else {
                            exchangeRate.setCurrency(currency);
                            nbu.add(exchangeRate);
                        }
                    }
                }
        }
    }
    public List<ExchangeRate> getPrivat() {
        update("privat");
        return privat;
    }

    public List<ExchangeRate> getMono() {
        update("mono");
        return mono;
    }
    public List<ExchangeRate> getNbu() {
        update("nbu");
        return nbu;
    }
}
