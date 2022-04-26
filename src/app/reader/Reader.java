package app.reader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.util.LinkedList;

import app.Edges;
import app.GrafoRepository;
import app.Vertices;
import app.VerticesRepository;

/**
 *
 * @author andrey
 */
public class Reader {

    static LinkedList<Edges> listEdges = new LinkedList<Edges>();

    final File verticesDoc = new File("./src/app/reader/vertices.csv");
    final File edgesDoc = new File("./src/app/reader/edges.csv");

    public boolean readDoc() {
        boolean result = false;

        try {
            FileReader vertices = new FileReader(verticesDoc);
            BufferedReader readvertices = new BufferedReader(vertices);

            String line = readvertices.readLine();
            while (line != null) {
                line = readvertices.readLine();
            }

            result = true;
            vertices.close();
        } catch (IOException e) {
        }

        return result;
    }

    public LinkedList<LinkedList<Edges>> fillList() {
        String verticeDocLine = "";
        String edgeDocLine = "";

        LinkedList<LinkedList<Edges>> list = new LinkedList<LinkedList<Edges>>();
        try {
            FileReader verticeDoc = new FileReader(verticesDoc);
            BufferedReader readvertices = new BufferedReader(verticeDoc);

            FileReader edgeDoc = new FileReader(edgesDoc);
            BufferedReader readEdges = new BufferedReader(edgeDoc);

            GrafoRepository grafo = new GrafoRepository();

            do {
                verticeDocLine = readvertices.readLine();
                if (verticeDocLine == null) {
                    break;
                }

                String[] vertices = verticeDocLine.split(",");
                int verticeId = Integer.parseInt(vertices[0]);
                String verticeName = vertices[1];

                Vertices vertice = createVertice(verticeId, verticeName);
                VerticesRepository verticeRepository = new VerticesRepository(vertice);

                grafo.addMainVertice(verticeRepository);
            } while (verticeDocLine != null);
            verticeDoc.close();

            do {
                edgeDocLine = readEdges.readLine();
                if (edgeDocLine == null) {
                    break;
                }

                String[] edges = edgeDocLine.split(",");
                int edgeId = Integer.parseInt(edges[0]);
                int origin = Integer.parseInt(edges[1]);
                int destiny = Integer.parseInt(edges[2]);
                double weight = Double.parseDouble(edges[3]);

                createEdge(edgeId, origin, destiny, weight);

                VerticesRepository verticeRepositoryOrigin = grafo.findById(origin);
                VerticesRepository verticeRepositoryDestiny = grafo.findById(destiny);

                Vertices verticeOrigin = verticeRepositoryOrigin.getVertices().getFirst();
                Vertices verticeDestiny = verticeRepositoryDestiny.getVertices().getFirst();;

                verticeRepositoryOrigin.addAdjacent(verticeDestiny);
                verticeRepositoryDestiny.addAdjacent(verticeOrigin);

            } while (edgeDocLine != null);

            System.out.println(grafo);

        } catch (IOException e) {
        }
        return list;
    }

    private Vertices createVertice(int id, String name) {
        return new Vertices(id, name);
    }

    private Edges createEdge(int id, int origin, int destiny, double weight) {
        return new Edges(id, origin, destiny, weight);
    }


}