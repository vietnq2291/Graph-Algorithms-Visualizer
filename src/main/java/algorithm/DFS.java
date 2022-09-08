package algorithm;

import components.graph.Graph;
import components.vertex.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    private Graph graph;
    private List<Vertex> visited;

    public void execute() {
        visited = new ArrayList<>();
        for (Vertex v : graph.getVertices().values()) {
            if (!visited.contains(v)) {
                recursiveDFS(v);
            }
        }
    }
    private void recursiveDFS(Vertex v) {
        visited.add(v);
        System.out.println("Visiting " + v);
        for (Vertex u : v.getNeighbors()) {
            System.out.print("Neighbor " + u + " of " + v);
            if (!visited.contains(u)) {
                System.out.println(" has not been visited yet!");
                recursiveDFS(u);
            }
            else {
                System.out.println(" has been visited");
            }
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
