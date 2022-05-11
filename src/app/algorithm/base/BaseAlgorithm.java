package app.algorithm.base;

import java.util.List;

import app.models.Edges;
import app.models.Vertices;
import app.repositories.VerticesRepository;

public abstract class BaseAlgorithm {

    protected int distance = Integer.MAX_VALUE;

    public int getDistance() {
        return this.distance;
    }

    public String printSteps(Edges origin, Edges destination) {
        return ""; //insira a lógica que eu n sei ainda aqui (eu lembro q tu fez mas n consigo achar)
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
