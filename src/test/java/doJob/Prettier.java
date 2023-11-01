package doJob;

import services.api_service.ExchangeRate;
import services.api_service.ExchangeRateManager;
import services.language_service.LanguageData;
import services.settings_service.Settings;

import java.util.Iterator;
import java.util.Objects;

public class Prettier {
    public static String DoJob(Settings s){
        //
        String divider= "\n=====================\n\n";
        StringBuilder sb = new StringBuilder();
        for (String bank : s.getBanks()) {
            sb.append(getPrettyBanks(bank, s));
            for (String currency : s.getCurrencies()) {
                ExchangeRate rate = ExchangeRateManager.getExchangeRate(bank,currency);
                sb.append(getPrettyRateString(rate,s));
            }
            sb.append(divider);
        }
        sb.delete(sb.length()-divider.length(),sb.length());
        return sb.toString();
    }
    private static String getPrettyRateString(ExchangeRate rate, Settings s) {
        StringBuilder sb = new StringBuilder();
        LanguageData.DoJobText doJobText = s.getLanguage().getDoJobText();
        if (Objects.nonNull(rate.getBank())){
            sb.append("______________________\n");
            sb.append("UAH/%s\n".formatted(rate.getCurrencyA()));
            sb.append(rate.getBank().equals("nbu")?
                    doJobText.NbuRate().formatted(getCutRate(rate.getBuy(),s.getDecimalPlaces())):
                    doJobText.BuySellText().formatted(getCutRate(rate.getBuy(),s.getDecimalPlaces()), getCutRate(rate.getSell(),s.getDecimalPlaces())));
        }
        return sb.toString();
    }
    public static String getPrettyBanks(String bank, Settings s) {
        return switch (bank) {
            case "privat" -> s.getLanguage().getBanksMenu().privatBankButton() + " ⬇\n";
            case "mono" -> s.getLanguage().getBanksMenu().monoBankButton() + "⬇\n";
            case "nbu" -> s.getLanguage().getBanksMenu().nbuBankButton() + "⬇\n";
            default -> throw new IllegalStateException("Unexpected value: " + bank);
        };
    }

    public static String getCutRate(String rate, int decimalPlaces ) {
        int index;
        if((index=rate.indexOf('.'))!=-1){
            int rateLength = index+1+(decimalPlaces==0?-1:decimalPlaces);

            if(rate.length()<rateLength){
            return   rate + String.join("", () -> new Iterator<>() {
                int count = 0;

                @Override
                public boolean hasNext() {
                    if ((rate.length() + count) < rateLength) {
                        count++;
                        return true;
                    }else return false;
                }

                @Override
                public String next() {
                    return "0";
                }
            });
        }
        else {
            return rate.substring(0, rateLength);
        }

        }
        else return "---";

    }
}
