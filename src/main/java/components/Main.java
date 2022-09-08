package components;

import algorithm.DFS;
import components.edge.DirectedEdge;
import components.edge.Edge;
import components.graph.UndirectedGraph;
import components.vertex.Vertex;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Integer[][] graph2 = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}
        };
        UndirectedGraph ug2 = new UndirectedGraph(graph2, true);


        ug2.printGraph();
        DFS dfs = new DFS();
        dfs.setGraph(ug2);
        dfs.execute();


    }
}
