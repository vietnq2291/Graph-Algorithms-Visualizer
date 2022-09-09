package components.edge;

import components.vertex.Vertex;

public class UndirectedEdge extends Edge {

    public UndirectedEdge(Vertex v1, Vertex v2) {
        super(v1, v2);
        super.setWeighted(false);
    }
    public UndirectedEdge(Vertex v1, Vertex v2, int weight) {
        super(v1, v2);
        super.setWeight(weight);
        super.setWeighted(true);
    }

    @Override
    public String toString() {
        return this.getEnds()[0] + " ---- " + this.getEnds()[1];
    }
}
