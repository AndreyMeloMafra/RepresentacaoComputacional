package app.algorithm;

import java.util.LinkedList;
import java.util.List;

import app.algorithm.base.BaseAlgorithm;
import app.models.Vertices;
import app.repositories.VerticesRepository;

public class BuscaEmExtensao extends BaseAlgorithm {

    LinkedList<Vertices> markeds = new LinkedList<>();
    LinkedList<Vertices> queue = new LinkedList<>();

    public Vertices execute(int startSearch, int verticeIdToFind, List<VerticesRepository> verticesList) {
        Vertices verticeActual = findInList(verticesList, startSearch);
        markeds.add(verticeActual);
        queue.add(verticeActual);

        Vertices visited;
        while (!queue.isEmpty()) {
            visited = queue.get(0);

            if (visited.getId() == verticeIdToFind) {
                return visited;
            }

            for (int iterator = 0; iterator < visited.getEdges().size(); iterator++) {

                int idToSearch = visited.getEdges().get(iterator).getDestiny();
                if (visited.getEdges().get(iterator).getDestiny() == visited.getId()) {
                    idToSearch = visited.getEdges().get(iterator).getOrigin();
                }
                Vertices nextVertice = findInList(verticesList, idToSearch);
                if (!nextVertice.equals(visited)) {

                    if (nextVertice.getId() == verticeIdToFind) {
                        return nextVertice;
                    }

                    if (!markeds.contains(nextVertice)) {
                        markeds.add(nextVertice);
                        queue.add(nextVertice);
                    }
                }
            }

            queue.remove(0);
        }

        visited = null;
        return visited;
    }

    public Vertices findInList(List<VerticesRepository> list, int verticeId) {
        Vertices vertices = null;

        for (VerticesRepository vertice : list) {
            if (vertice.getFirstElementId() == verticeId) {
                vertices = vertice.getVertices().get(0);
            }
        }

        return vertices;
    }
}
