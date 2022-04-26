package app;

import app.reader.Reader;

public class App {
    public static void main(String[] args) throws Exception {

        Reader reader = new Reader();

        reader.readDoc();
        reader.fillList();
    }
}
