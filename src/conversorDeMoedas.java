import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// Record para mapear apenas o resultado final da conversão que vem no JSON da API
record RespostaApi(double conversion_result) {}

public class conversorDeMoedas {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Coloque sua chave da ExchangeRate-API aqui dentro das aspas
        String apiKey = "515fd9e47070a7b596672215";

        String menu = """
                *****************************************************
                Seja bem-vindo/a ao Conversor de Moedas!
                
                1) Dólar (USD) => Real (BRL)
                2) Real (BRL) => Dólar (USD)
                3) Peso Argentino (ARS) => Real (BRL)
                4) Real (BRL) => Peso Argentino (ARS)
                5) Peso Colombiano (COP) => Real (BRL)
                6) Real (BRL) => Peso Colombiano (COP)
                7) Sair
                
                Escolha uma opção válida:
                *****************************************************
                """;

        int opcao = 0;

        // Loop principal do programa
        while (opcao != 7) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            if (opcao == 7) {
                System.out.println("Encerrando o conversor. Até logo!");
                break;
            }

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida! Tente novamente.\n");
                continue;
            }

            System.out.println("Digite o valor que deseja converter:");
            double valor = leitura.nextDouble();
            String moedaBase = "";
            String moedaAlvo = "";

            // Definindo as moedas com base na opção escolhida
            switch (opcao) {
                case 1 -> { moedaBase = "USD"; moedaAlvo = "BRL"; }
                case 2 -> { moedaBase = "BRL"; moedaAlvo = "USD"; }
                case 3 -> { moedaBase = "ARS"; moedaAlvo = "BRL"; }
                case 4 -> { moedaBase = "BRL"; moedaAlvo = "ARS"; }
                case 5 -> { moedaBase = "COP"; moedaAlvo = "BRL"; }
                case 6 -> { moedaBase = "BRL"; moedaAlvo = "COP"; }
            }

            // Montando a URL de requisição para a API
            String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaBase + "/" + moedaAlvo + "/" + valor;

            try {
                // Fazendo a requisição HTTP
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // Transformando o JSON da resposta em um objeto Java usando Gson
                Gson gson = new Gson();
                RespostaApi resposta = gson.fromJson(response.body(), RespostaApi.class);

                // Exibindo o resultado formatado
                System.out.printf("O valor de %.2f [%s] corresponde ao valor final de =>> %.2f [%s]\n\n",
                        valor, moedaBase, resposta.conversion_result(), moedaAlvo);

            } catch (Exception e) {
                System.out.println("Ocorreu um erro na conversão: " + e.getMessage());
            }
        }
        leitura.close();
    }
}