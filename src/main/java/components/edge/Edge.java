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
    public Edge(Vertex v1, Vertex v2, int weight) {
        ends[0] = v1;
        ends[1] = v2;
        this.weight = weight;
        this.isWeighted = true;
    }

    public Vertex[] getEnds() {
        return ends;
    }
}
