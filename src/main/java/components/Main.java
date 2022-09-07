package components;

import components.edge.DirectedEdge;
import components.edge.Edge;
import components.graph.UndirectedGraph;
import components.vertex.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Edge e = new DirectedEdge(new Vertex(1), new Vertex(2));


        HashMap<Integer, Integer[]> graph = new HashMap<>();
        graph.put(1, new Integer[] {2, 5});
        graph.put(2, new Integer[] {1, 5, 3, 4});
        graph.put(3, new Integer[] {2, 4});
        graph.put(4, new Integer[] {2, 5, 3});
        graph.put(5, new Integer[] {4, 1, 2});

        UndirectedGraph ug = new UndirectedGraph(graph);


    }
}
