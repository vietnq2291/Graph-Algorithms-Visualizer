package components.edge;

import components.vertex.Vertex;

public abstract class Edge {

    private Vertex[] ends = new Vertex[2];
    private int weight = 0;
    private boolean isWeighted;

    public Edge(Vertex v1, Vertex v2) {
        ends[0] = v1;
        ends[1] = v2;
    }

    public Vertex[] getEnds() {
        return ends;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        this.isWeighted = true;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }

    @Override
    public String toString() {
        return ends[0] + " --- " + ends[1];
    }
}
