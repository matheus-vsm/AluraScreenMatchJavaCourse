import br.com.alura.screenmatch.modelos.Filme;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme();

        filme.setNome("Dragon Ball");
        filme.setAnoDeLancamento(2012);
        filme.exibeFichaTecnica();
        filme.avalia(8);
        filme.avalia(5);
        filme.avalia(10);
        System.out.println(filme.obterMedia());
        System.out.println("Total de Avaliações: " + filme.getTotalDeAvaliacoes());
    }
}