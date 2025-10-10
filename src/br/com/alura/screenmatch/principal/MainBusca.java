package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        String url = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=6585022c";

        try {
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
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // Define a política de nomenclatura, os nomes dos campos começarão com letra maiúscula (ex: "Title" em vez de "title")
                    .create(); // Cria a instância configurada do Gson
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println(STR."Aconteceu um erro: \{e.getMessage()}");
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro foi detectado. Verifique o endereço.");
        } catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizou!");
        }
    }
}
