package br.com.alura.minhasmusicas.modelos;

public class MinhasPreferidas {
    public void incluir(Audio audio){
        System.out.println(audio.getTitulo() + (audio.getClassificacao() >= 8 ? " é muito dahora!" : " é legalzinho..."));
    }
}
