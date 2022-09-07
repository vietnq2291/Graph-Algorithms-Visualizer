package components.graph;

import java.util.HashMap;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(HashMap<Integer, Integer[]> adjacencyList) {
        super(adjacencyList, false);
    }

}
