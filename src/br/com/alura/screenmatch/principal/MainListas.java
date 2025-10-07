package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(2);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(5);
        Filme filmeDoPaulo = new Filme("Algum", 2001);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);
        
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (var item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação do filme " + filme.getNome() + ": " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Kanye West");
        buscaPorArtista.add("Matheus");
        buscaPorArtista.add("Alice");
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
