package app.exceptions;

public class EdgeNotFoundException extends RuntimeException{

    public EdgeNotFoundException() {
        super("Aresta não encontrada");
    }
    
}
