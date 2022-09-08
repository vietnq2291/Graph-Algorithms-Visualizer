package components.vertex;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int id;
    private List<Vertex> neighbors;

    public Vertex(int id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }
    public Vertex(int id, List neighbors) {
        this.id = id;
        this.neighbors = neighbors;
    }

    public void addNeighbor(Vertex v) {
        if (!neighbors.contains(v)) {
            this.neighbors.add(v);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
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

    @Override
    public String toString() {
        return "(" + id + ")";
    }
}
