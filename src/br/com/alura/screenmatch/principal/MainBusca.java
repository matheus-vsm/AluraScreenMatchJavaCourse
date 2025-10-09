package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainBusca {
    static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um Filme para buscar: ");
        var busca = input.nextLine();

        String url = "https://www.omdbapi.com/?t=" + busca + "&apikey=6585022c";

        // Cria um cliente HTTP usando a API nativa do Java
        HttpClient client = HttpClient.newHttpClient();

        // Cria uma requisição HTTP
        HttpRequest request = HttpRequest.newBuilder() // Aqui usamos o metodo "newBuilder()" para configurar a requisição.
                .uri(URI.create(url)) //uri() define o endereço (endpoint) da API que queremos acessar.
                .build(); // Finaliza a construção da requisição

        // Cria uma resposta HTTP
        // O metodo "send" é síncrono (aguarda o servidor responder)
        // "HttpResponse.BodyHandlers.ofString()" indica que queremos o corpo da resposta como uma String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
