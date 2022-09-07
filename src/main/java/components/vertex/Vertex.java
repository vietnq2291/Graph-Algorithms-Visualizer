package components.vertex;

public class Vertex {

    private int id;

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex v = (Vertex) o;
            return this.id == v.id;
        } else {
            return false;
        }
    }
}
