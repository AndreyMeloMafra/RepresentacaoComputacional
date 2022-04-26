package app;

import java.util.LinkedList;

public class GrafoRepository {
    LinkedList<VerticesRepository> vertices = new LinkedList<VerticesRepository>();

    public LinkedList<VerticesRepository> getVertices() {
        return vertices;
    }

    public void addMainVertice(VerticesRepository verticeToAdd) {
        vertices.add(verticeToAdd);
    }

    public void removeMainVertice(VerticesRepository verticeToAdd) {
        vertices.remove(verticeToAdd);
    }

    public VerticesRepository findById(int originId) {
        try {
            for (VerticesRepository verticesRepository : vertices) {
                if (verticesRepository.getFirstElementId() == originId) {
                    return verticesRepository;
                }
            }
        } catch (Exception e) {
            throw new Error();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Vertices: ");
        for (int iterator = 0; iterator < vertices.size(); iterator++) {
            result.append("{");
            result.append(vertices.get(iterator));
            result.append("},");
        }

        return result.toString();
    }
}
