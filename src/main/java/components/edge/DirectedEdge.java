package components.edge;

import components.vertex.Vertex;

public class DirectedEdge extends Edge {

    private Vertex beginVertex;
    private Vertex endVertex;

    public DirectedEdge(Vertex begin, Vertex end) {
        super(begin, end);
        this.beginVertex = begin;
        this.endVertex = end;
    }

    public Vertex getBeginVertex() {
        return beginVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }
}
