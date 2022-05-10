package app.algorithm;

import app.algorithm.base.BaseAlgorithm;
import app.models.Edges;
import app.models.Vertices;

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

    public void execute(Vertices originVertices) {
        //Executa o algoritmo de djsidjfdgfhod (eu não sei escrever)
        originVertices.setMinDistance(0);
        if (originVertices != null) { //pode ser que essa checagem aqui quebre alguma coisa vu
            this.queue.add(originVertices);
        }
        while (!(this.queue.isEmpty())) {
            Vertices vertice = this.queue.poll(); //???? mano que
            for (Edges edges : vertice.getEdges()) {
                Vertices ver = edges.getDestination(); //falta ver como a gente vai fazer essa implementação daqui
                double weight = edges.getWeight();
                double minDistance = vertice.getMinDistance() + weight;
                if (minDistance < ver.getMinDistance()) {
                    this.queue.remove(vertice);
                    ver.setPreviousVertices(vertice);
                    ver.setMinDistance(minDistance);
                    this.queue.add(ver);
                }
            }
        }
    }

    public List<Vertices> getShortestPath(Vertices destination) {
        List<Vertices> path = new ArrayList<>();
        for (Vertices vertices = destination; vertices != null; vertices = vertices.getPreviousVertices()) {
            path.add(vertices);
        }
        Collections.reverse(path);
        return path;
    }
}
