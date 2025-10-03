//package br.com.alura.minhasmusicas.principal;
//
//import br.com.alura.minhasmusicas.modelos.MinhasPreferidas;
//import br.com.alura.minhasmusicas.modelos.Musica;
//import br.com.alura.minhasmusicas.modelos.Podcast;
//
//public class Main {
//    public static void main(String[] args) {
//        Musica musica = new Musica();
//        musica.setCantor("Ye");
//        musica.setTitulo("Bound 2");
//
//        for (int i = 0; i < 20000; i++){
//            musica.reproduzir();
//        }
//        for (int i = 0; i < 200; i++){
//            musica.curtir();
//        }
//
//        Podcast podcast = new Podcast();
//        podcast.setTitulo("Podpah");
//        podcast.setApresentador("Igao e Mitico");
//
//        for (int i = 0; i < 10000; i++){
//            podcast.reproduzir();
//        }
//        for (int i = 0; i < 100; i++){
//            podcast.curtir();
//        }
//
//        MinhasPreferidas preferidas = new MinhasPreferidas();
//        preferidas.incluir(musica);
//        preferidas.incluir(podcast);
//    }
//}