package app.repositories;

import java.util.LinkedList;
import java.util.List;

import app.models.Vertices;

public class VerticesRepository {
    private LinkedList<Vertices> vertices = new LinkedList<>();

    public VerticesRepository(Vertices initialVertice) {
        vertices.add(initialVertice);
    }

    public List<Vertices> getVertices() {
        return vertices;
    }

    public void addAdjacent(Vertices verticeToAdd) {
        vertices.add(verticeToAdd);
    }

    public void removeAdjacent(Vertices verticeToAdd) {
        vertices.remove(verticeToAdd);
    }

    public int getFirstElementId() {
        return vertices.getFirst().getId();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int iterator = 0; iterator < vertices.size(); iterator++) {
            if (iterator == 1) {
                result.append("Vertices adjacentes: ");
            }
            result.append("[");
            result.append(vertices.get(iterator));
            result.append("],");
            result.append("\n");
        }

        return result.toString();
    }
}
