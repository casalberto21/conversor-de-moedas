package br.com.carlos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyJsonParser {
    public static double parseRate(String json, String targetCurrency) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
        return rates.get(targetCurrency).getAsDouble();
    }
}