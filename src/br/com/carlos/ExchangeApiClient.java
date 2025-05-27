package br.com.carlos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApiClient {
    private static final String API_KEY = System.getenv("API_KEY");

    public String buscarDados(String baseCurrency) throws IOException, InterruptedException {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new IllegalStateException("API_KEY não definida no ambiente.");
        }

        if (API_KEY == null || API_KEY.isBlank()) {
            throw new IllegalStateException("API_KEY não definida no ambiente.");
        }

        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro na API: código " + response.statusCode());
        }

        return response.body();
    }

    public static void main(String[] args) {
        ExchangeApiClient client = new ExchangeApiClient();
        try {
            String resultado = client.buscarDados("USD");
            System.out.println("Resposta da API: " + resultado);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
