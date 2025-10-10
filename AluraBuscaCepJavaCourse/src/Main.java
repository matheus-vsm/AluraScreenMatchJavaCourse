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

            try {
                ConsultaCep consultaCep = new ConsultaCep();

                EnderecoViaCep meuEnderecoViaCep = consultaCep.buscaEndereco(busca);
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
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            for (var endereco : enderecos){
                gerador.gerarJson(endereco);
            }
        }
        System.out.println("\nTodos endereços adicionados:");
        for (var endereco : enderecos){
            System.out.println("- " + endereco);
        }
    }
}
