package app;

import app.algorithm.BuscaEmExtensao;
import app.algorithm.Dijkstra;
import app.reader.Reader;
import app.repositories.GrafoRepository;

public class App {

    static GrafoRepository grafo;
    
    public static void main(String[] args) {

        Reader visaoComputacional = new Reader();
        int opcao = 0;

        grafo = reader.fillList();
        System.out.println("Escolha o algoritmo que vai ser utilizado: ");
        /*
        Recebe aqui (tô com preguiça de pesquisar como que faz o input agora)
        1 pro que eu esqueci o nome agora, 2 pra destra
        3 pra sair do programa
         */
        while (opcao > 3 || opcao < 1) {
            System.out.println("Opção inválida");
            //pede input de novo aqui
        }
        switch (opcao) {
            case 1:
                new BuscaEmExtensao();
                break;
            case 2:
                new Dijkstra();
                break;
            case 3:
                //adios
                break;
        }

    }
}
