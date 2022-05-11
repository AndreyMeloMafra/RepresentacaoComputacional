package app;

import java.util.List;
import java.util.Scanner;

import app.algorithm.BuscaEmExtensao;
import app.algorithm.Dijkstra;
import app.models.Vertices;
import app.reader.Reader;
import app.repositories.GrafoRepository;

public class App {

    static GrafoRepository grafo;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Reader visaoComputacional = new Reader();

        int menuOption = 0;
        int verticeStartInput = 0;
        int verticeEndInput = 0;

        grafo = visaoComputacional.fillList();
        grafo.getVertices().get(0);
        /*
         * Recebe aqui (tô com preguiça de pesquisar como que faz o input agora)
         * 1 pro que eu esqueci o nome agora, 2 pra destra
         * 3 pra sair do programa
         */
        System.out.println("Menu");
        System.out.println("--------------------------------");
        System.out.println("1 - Busca em extensão");
        System.out.println("2 - Custo mínimo ");
        System.out.println("Qualquer tecla - Sair do programa");

        do {
            System.out.println("--------------------------------");
            System.out.print("Escolha o algoritmo que vai ser utilizado: ");
            menuOption = scanner.nextInt();
        } while (menuOption > 3 || menuOption < 1);

        do {
            if(menuOption != 2) {
                System.out.print("Escolha o  vertice de partida: ");
                verticeStartInput = scanner.nextInt();
                
            }
                System.out.print("Escolha o  vertice de chegada: ");
                verticeEndInput = scanner.nextInt();
        } while (verticeStartInput > grafo.getVertices().size() && verticeEndInput < grafo.getVertices().size());

        switch (menuOption) {
            case 1:
                BuscaEmExtensao buscaEmExtensao = new BuscaEmExtensao();

                buscaEmExtensao.execute(verticeStartInput, verticeEndInput,
                        grafo.getVertices());
                break;
            case 2:
                Dijkstra dijkstra = new Dijkstra();
                dijkstra.execute(grafo.getVertices());
                List<Vertices> vertices = dijkstra.getShortestPath(verticeEndInput, grafo.getVertices());
                printList(vertices);
                break;
            default:
                break;
        }
        scanner.close();
    }

    private static void printList(List<Vertices> vertices) {
        for (Vertices vertice : vertices) {
            System.out.println("Caminho: " + vertice.getName());
        }
    }
}
