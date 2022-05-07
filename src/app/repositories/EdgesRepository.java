package app.repositories;

import java.util.LinkedList;
import java.util.List;

import app.exceptions.EdgeNotFoundException;
import app.models.Edges;

public class EdgesRepository {
    private LinkedList<Edges> edges = new LinkedList<>();

    public List<Edges> getEdges() {
        return edges;
    }

    public void add(Edges edgeToAdd) {
        edges.add(edgeToAdd);
    }

    public void remove(Edges edgeToAdd) {
        edges.remove(edgeToAdd);
    }

    public Edges finEdgesByOriginAndDestiny(int origin, int destiny) {
        try {
            for (Edges edge : edges) {
                if (compair(edge.getOrigin(), edge.getDestination(), origin, destiny)) {
                    return edge;
                }
            }
        } catch (Exception e) {
            throw new EdgeNotFoundException();
        }
        return null;
    }

    private boolean compair(int origin, int destiny, int originToCompair, int destinyToCompair) {
        return origin == originToCompair && destiny == destinyToCompair;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int iterator = 0; iterator < edges.size(); iterator++) {
            if (iterator == 1) {
                result.append("Edges adjacentes: ");
            }
            result.append("[");
            result.append(edges.get(iterator));
            result.append("],");
            result.append("\n");
        }

        return result.toString();
    }
}
