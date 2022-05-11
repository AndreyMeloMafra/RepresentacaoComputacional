package app.algorithm;

import app.algorithm.base.BaseAlgorithm;
import app.models.Edges;
import app.models.Vertices;
import app.repositories.VerticesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra extends BaseAlgorithm {

    private int distance;
    PriorityQueue<Vertices> queue; //mano tem que ver o que é essa priority queue KKKKJJJKJJKKJJK

    public Dijkstra() {
        this.distance = 0;
        this.queue = new PriorityQueue<>();
    }

    public int getDistance() {
        return this.distance;
    }

    public void execute(int startIndex, List<VerticesRepository> verticesList) {
        Vertices originVertices = findInList(verticesList, startIndex);
        originVertices.setMinDistance(0);
        if (originVertices != null) {
            this.queue.add(originVertices);
        }
        while (!this.queue.isEmpty()) {
            Vertices vertice = this.queue.poll(); 
            
            for (Edges edges : vertice.getEdges()) {
                Vertices destinyVertice = findInList(verticesList, edges.getDestiny()); 
                double weight = edges.getWeight();
                double minDistance = vertice.getMinDistance() + weight;

                if (minDistance < destinyVertice.getMinDistance()) {
                    this.queue.remove(vertice);
                    destinyVertice.setPreviousVertices(vertice);
                    destinyVertice.setMinDistance(minDistance);
                    this.queue.add(destinyVertice);
                }
            }
        }
    }

    public List<Vertices> getShortestPath(int destinationId, List<VerticesRepository> verticesList) {
        List<Vertices> path = new ArrayList<>();
        Vertices destination = findInList(verticesList, destinationId);

        for (Vertices vertices = destination; vertices != null; vertices = vertices.getPreviousVertices()) {
            path.add(vertices);
        }
        Collections.reverse(path);
        return path;
    }
}
