package Services.APIService;
import Services.SettingsService.Settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiLogic {
    public ExchangeRate getExchangeRate(Settings s) {
        try {
            URL url = new URL(s.getURL());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (s.getToken() != null) {connection.setRequestProperty("X-Token", s.getToken());}
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
                JsonArray currencyData = JsonParser.parseString(respBody).getAsJsonArray();
                ExchangeRate exchangeRate = new ExchangeRate();
                exchangeRate.setBank(s.getBank());
                for (JsonElement element : currencyData) {
                    JsonObject currency = element.getAsJsonObject();
                    if (s.getBank().equals("privat") ? s.getCurrency().equals(currency.get(s.getCurrencyTargetForJson()).getAsString()) :
                            Integer.parseInt(s.getCurrency()) == currency.get(s.getCurrencyTargetForJson()).getAsInt()) {
                        exchangeRate.setCurrency(currency.get(s.getCurrencyTargetForJson()).getAsString());
                        exchangeRate.setBuy(currency.get(s.getBuyTargetForJson()).getAsString());
                        if (s.getSellTargetForJson() != null) {
                            exchangeRate.setSell(currency.get(s.getSellTargetForJson()).getAsString());
                        }
                    }
                }
                return exchangeRate;
            } else {
                System.out.println("Error: " + respCode);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
