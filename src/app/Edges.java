package app;
public class Edges {

    private int id;
    private int origin;
    private int destiny;
    private double weight;

    public Edges(int id, int origin, int destiny, double weight) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getOrigin() {
        return origin;
    }

    public int getDestiny() {
        return destiny;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Aresta: (");
        result.append(this.id);
        result.append("|");
        result.append(this.origin);
        result.append("|");
        result.append(this.destiny);
        result.append("|");
        result.append(this.weight);
        result.append(")");
        result.append("\n");


        return result.toString();
    }
}
