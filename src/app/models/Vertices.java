package app.models;

import java.util.ArrayList;
import java.util.List;

public class Vertices {

    private int id;
    private String name;
    private List<Edges> edges;
    private boolean alreadyVisited;
    private Vertices previousVertices;
    private double minDistance = Double.MAX_VALUE; //começa com a disância infinita

    public Vertices(int id, String name) {
        this.id = id;
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void addNeighbour(Edges edge) {
        this.edges.add(edge);
    }

    public List<Edges> getEdges() {
        return this.edges;
    }

    public boolean wasNodeVisited() {
        return this.alreadyVisited;
    }

    public Vertices getPreviousVertices() {
        return this.previousVertices;
    }

    public Vertices setPreviousVertices(Vertices previousVertices) {
        return this.previousVertices = previousVertices;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinDistance() {
        return this.minDistance;
    }

    public double setMinDistance(double minDistance) {
        return this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Vértice: (");
        result.append(this.id);
        result.append(" | ");
        result.append(this.name);
        result.append(")");
        result.append("\n");

        return result.toString();
    }
}
