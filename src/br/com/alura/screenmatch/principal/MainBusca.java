package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainBusca {
    static void main(String[] args) throws IOException, InterruptedException {
        // Cria um cliente HTTP usando a API nativa do Java
        HttpClient client = HttpClient.newHttpClient();

        // Cria uma requisição HTTP
        HttpRequest request = HttpRequest.newBuilder() // Aqui usamos o método "newBuilder()" para configurar a requisição.
                .uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=6585022c")) //uri() define o endereço (endpoint) da API que queremos acessar.
                .build(); // Finaliza a construção da requisição

        // Cria uma resposta HTTP
        // O metodo "send" é síncrono (aguarda o servidor responder)
        // "HttpResponse.BodyHandlers.ofString()" indica que queremos o corpo da resposta como uma String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
