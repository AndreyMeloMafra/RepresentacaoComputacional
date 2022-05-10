package app.repositories;

import java.util.LinkedList;
import java.util.List;

import app.exceptions.VerticeNotFoundException;
import app.models.Vertices;

public class GrafoRepository {
    LinkedList<VerticesRepository> vertices = new LinkedList<>();

    public List<VerticesRepository> getVertices() {
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
                if (compair(verticesRepository.getFirstElementId(), originId)) {
                    return verticesRepository;
                }
            }
        } catch (Exception e) {
            throw new VerticeNotFoundException();
        }
        return null;
    }

    private boolean compair(int id, int idToCompair) {
        return id == idToCompair;
    }

    public VerticesRepository getVerticeById(int id) {
        VerticesRepository verticeToReturn = null;
        for (VerticesRepository vertice : vertices) {
            if (vertice.getFirstElementId() == id) {
                verticeToReturn = vertice;
            }
        }

        return verticeToReturn;
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
