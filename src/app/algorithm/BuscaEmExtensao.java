package app.algorithm;

import java.util.LinkedList;
import java.util.List;

import app.algorithm.base.BaseAlgorithm;
import app.models.Vertices;
import app.repositories.VerticesRepository;

public class BuscaEmExtensao extends BaseAlgorithm {

    LinkedList<Vertices> markeds = new LinkedList<>();
    LinkedList<Vertices> queue = new LinkedList<>();

    public void execute(int startSearch, int verticeIdToFind, List<VerticesRepository> verticesList) {
        Vertices verticeActual = findInList(verticesList, startSearch);
        markeds.add(verticeActual);
        queue.add(verticeActual);

        Vertices visited = queue.get(0);
        System.out.println("Partida: " + visited.getName());
        while (!queue.isEmpty()) {
            visited = queue.get(0);

            for (int iterator = 0; iterator < visited.getEdges().size(); iterator++) {

                int idToSearch = visited.getEdges().get(iterator).getDestiny();
                if (visited.getEdges().get(iterator).getDestiny() == visited.getId()) {
                    idToSearch = visited.getEdges().get(iterator).getOrigin();
                }
                Vertices nextVertice = findInList(verticesList, idToSearch);
                
                if (!nextVertice.equals(visited)) {      
                    if (!markeds.contains(nextVertice)) {
                        System.out.println("Proximo: " + nextVertice.getName());
                        markeds.add(nextVertice);
                        queue.add(nextVertice);
                    }
                }
            }

            queue.remove(0);
        }
    }
}
