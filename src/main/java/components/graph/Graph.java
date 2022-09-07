package components.graph;

import components.edge.Edge;
import components.edge.UndirectedEdge;
import components.vertex.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph(HashMap<Integer, Integer[]> graph, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();

        for (int vertexId : graph.keySet()) {
            Vertex v = new Vertex(vertexId);
            vertices.add(v);

            for (int adjacentVertexId : graph.get(vertexId)) {
                if (!vertices.contains(new Vertex(vertexId))) {
                    Vertex adj = new Vertex(adjacentVertexId);
                    edges.add(new UndirectedEdge(v, adj));
                }
            }
        }
    }

}
