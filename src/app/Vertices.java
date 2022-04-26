package app;

public class Vertices {

    private int id;
    private String name;

    public Vertices(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
}
