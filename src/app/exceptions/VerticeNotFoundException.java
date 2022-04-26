package app.exceptions;

public class VerticeNotFoundException extends RuntimeException{

    public VerticeNotFoundException() {
        super("Vértice não encontrado");
    }
    
}
