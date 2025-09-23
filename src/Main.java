public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme();

        filme.nome = "Dragon Ball";
        filme.anoDeLancamento = 2012;
        filme.exibeFichaTecnica();
        filme.avalia(8);
        filme.avalia(5);
        filme.avalia(10);
        System.out.println(filme.somaDasAvaliacoes);
        System.out.println(filme.totalDeAvaliacoes);
        System.out.println(filme.obterMedia());
    }
}