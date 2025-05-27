package br.com.carlos;

import java.util.Scanner;

public class ExchangeApiService {
    private final ExchangeApiClient client = new ExchangeApiClient();

    public double converterMoeda(int opcao, double valor) throws Exception {
        String base = "", destino = "";

        switch (opcao) {
            case 1 -> { base = "USD"; destino = "BRL"; }
            case 2 -> { base = "BRL"; destino = "USD"; }
            case 3 -> { base = "EUR"; destino = "BRL"; }
            case 4 -> { base = "BRL"; destino = "EUR"; }
            case 5 -> { base = "USD"; destino = "EUR"; }
            case 6 -> { base = "EUR"; destino = "USD"; }
            default -> throw new Exception("Opção inválida");
        }

        String json = client.buscarDados(base);
        double taxa = CurrencyJsonParser.parseRate(json, destino);
        return valor * taxa;
    }

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ExchangeApiService service = new ExchangeApiService();

            System.out.println("\n=== CONVERSOR DE MOEDAS ===");

            while (true) {
                System.out.println("\nEscolha uma conversão:");
                System.out.println("1 - USD para BRL");
                System.out.println("2 - BRL para USD");
                System.out.println("3 - EUR para BRL");
                System.out.println("4 - BRL para EUR");
                System.out.println("5 - USD para EUR");
                System.out.println("6 - EUR para USD");
                System.out.println("0 - Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 0) break;

                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();

                try {
                    double resultado = service.converterMoeda(opcao, valor);
                    System.out.println("Valor convertido: " + resultado);
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            scanner.close();
        }
    }
}