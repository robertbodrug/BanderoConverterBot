package Services.APIService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRates {
    private ApiSettings settings;
    private List<ExchangeRate> privat = new ArrayList<>();
    private List<ExchangeRate> mono = new ArrayList<>();
    private List<ExchangeRate> nbu = new ArrayList<>();
    public JsonArray createJsonArrayExchangeRate(ApiSettings s) {
            try {
                URL url = new URL(s.getURL());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                if (s.getToken() != null) {
                    connection.setRequestProperty("X-Token", s.getToken());
                }
                int respCode = connection.getResponseCode();
                if (respCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder resp = new StringBuilder();
                    String input;
                    while ((input = in.readLine()) != null) {
                        resp.append(input);
                    }
                    in.close();
                    String respBody = resp.toString();
                    return JsonParser.parseString(respBody).getAsJsonArray();
                } else {
                    System.out.println("Error: " + respCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
    public void createExchangeRates(String bank) {
        String[] currencies = new String[]{"USD", "EUR"};
        settings = new ApiSettings();
        settings.setBank(bank);
        for (JsonElement element : createJsonArrayExchangeRate(settings)) {
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
                        if (bank.equals("privat")) {
                            exchangeRate.setCurrency(currency);
                            privat.add(exchangeRate);
                        } else if (bank.equals("mono")) {
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
    public List<ExchangeRate> getPrivat () {
        createExchangeRates("privat");
        return privat;
    }

    public List<ExchangeRate> getMono () {
        createExchangeRates("mono");
        return mono;
    }
    public List<ExchangeRate> getNbu () {
        createExchangeRates("nbu");
        return nbu;
    }
}
