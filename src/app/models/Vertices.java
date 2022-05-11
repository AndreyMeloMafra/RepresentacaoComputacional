package app.models;

import java.util.ArrayList;
import java.util.List;

public class Vertices implements Comparable<Vertices> {

    private Integer id;
    private String name;
    private List<Edges> edges;
    private boolean alreadyVisited;
    private Vertices previousVertices;
    private double minDistance = Double.MAX_VALUE; //começa com a disância infinita

    public Vertices(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public Integer getId() {
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

    public void setPreviousVertices(Vertices previousVertices) {
        this.previousVertices = previousVertices;
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

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Vertices)) {
            return false;
        }

        Vertices vertice = (Vertices) obj;

        return vertice.id == this.id && vertice.name == this.name;
    }

    @Override
    public int compareTo(Vertices o) {
        return this.getId().compareTo(o.getId());
    }
}
