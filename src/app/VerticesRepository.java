package app;

import java.util.LinkedList;

public class VerticesRepository {
    private LinkedList<Vertices> vertices = new LinkedList<Vertices>();

    public VerticesRepository(Vertices initialVertice) {
        vertices.add(initialVertice);
    }

    public LinkedList<Vertices> getVertices() {
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
            if(iterator == 1) {
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
