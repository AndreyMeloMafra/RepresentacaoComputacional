package app.reader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;

import app.models.Edges;
import app.models.Vertices;
import app.repositories.EdgesRepository;
import app.repositories.GrafoRepository;
import app.repositories.VerticesRepository;

/**
 *
 * @author andrey (lindo)
 */
public class Reader {

    String verticeFile;
    String edgeFile;

    File verticesDoc = new File("./src/app/reader/vertices.csv");
    File edgesDoc = new File("./src/app/reader/edges.csv");

    FileReader verticeDoc;
    BufferedReader readvertices;
    FileReader edgeDoc;
    BufferedReader readEdges;

    // public Reader(String verticeFile, String edgeFile) {
    //     this.verticeFile = verticeFile;
    //     this.edgeFile = edgeFile;

    //     // this.verticesDoc = new File(verticeFile);
    //     // this.edgesDoc = new File(edgeFile);
    // }

    public Reader() {
        try {
            verticeDoc = new FileReader(verticesDoc);
            readvertices = new BufferedReader(verticeDoc);

            edgeDoc = new FileReader(edgesDoc);
            readEdges = new BufferedReader(edgeDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GrafoRepository fillList() {
        GrafoRepository grafo = new GrafoRepository();

        try {
            generateMainVertices(readvertices, grafo);
            generateEdges(grafo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grafo;
    }

    private Vertices createVertice(String line) {
        String[] vertices = line.split(",");
        int verticeId = Integer.parseInt(vertices[0]);
        String verticeName = vertices[1];

        return new Vertices(verticeId, verticeName);
    }

    private Edges createEdge(String line) {
        String[] edges = line.split(",");
        int edgeId = Integer.parseInt(edges[0]);
        int origin = Integer.parseInt(edges[1]);
        int destiny = Integer.parseInt(edges[2]);
        double weight = Double.parseDouble(edges[3]);

        return new Edges(edgeId, origin, destiny, weight);
    }

    private void generateMainVertices(BufferedReader reader, GrafoRepository grafo) throws IOException {
        String line = "";
        try {
            do {
                line = reader.readLine();

                if (line == null) {
                    break;
                }

                Vertices vertice = createVertice(line);
                VerticesRepository verticeRepository = new VerticesRepository(vertice);

                grafo.addMainVertice(verticeRepository);
            } while (!line.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateEdges(GrafoRepository grafo) {
        String line = "";

        EdgesRepository edgesRepository = new EdgesRepository();

        try {
            do {
                line = readEdges.readLine();
                if (line == null) {
                    break;
                }

                Edges edgeCreated = createEdge(line);

                edgesRepository.add(edgeCreated);

                VerticesRepository verticeRepositoryOrigin = grafo.findById(edgeCreated.getOrigin());
                VerticesRepository verticeRepositoryDestiny = grafo.findById(edgeCreated.getDestiny());

                Vertices verticeOrigin = verticeRepositoryOrigin.getVertices().get(0);
                Vertices verticeDestiny = verticeRepositoryDestiny.getVertices().get(0);

                verticeRepositoryOrigin.addAdjacent(verticeDestiny);
                verticeRepositoryDestiny.addAdjacent(verticeOrigin);

                verticeOrigin.addNeighbour(edgeCreated);
                verticeDestiny.addNeighbour(edgeCreated);

            } while (!line.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}