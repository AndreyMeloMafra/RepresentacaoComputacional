package app;

import app.reader.Reader;
import app.repositories.GrafoRepository;

public class App {

    static GrafoRepository grafo;
    
    public static void main(String[] args) {

        Reader reader = new Reader();

        grafo = reader.fillList();
    }
}
