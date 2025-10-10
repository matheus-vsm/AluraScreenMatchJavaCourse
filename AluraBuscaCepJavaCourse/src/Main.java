import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String busca = "";
        List<Endereco> enderecos = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        while (!busca.equalsIgnoreCase("sair")) {
            System.out.print("Digite um CEP ou 'sair' para cancelar: ");
            busca = input.nextLine();

            if (busca.equalsIgnoreCase("sair")) { break; }

            String url = "https://viacep.com.br/ws/" + busca + "/json/";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                EnderecoViaCep meuEnderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
                Endereco meuEndereco = new Endereco(meuEnderecoViaCep);

                if (meuEndereco.getCep() == null) {
                    System.out.println("CEP não encontrado.\n");
                    continue;
                }

                enderecos.add(meuEndereco);
                System.out.println("O endereço completo do CEP " + meuEndereco.getCep() + " foi adicionado com sucesso.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro " + e.getMessage());
            }
            FileWriter escrita = new FileWriter("enderecos.json");
            escrita.write(gson.toJson(enderecos));
            escrita.close();
        }
        System.out.println("\nTodos endereços adicionados:");
        for (var endereco : enderecos){
            System.out.println("- " + endereco);
        }
    }
}
