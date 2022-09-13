package components.graph;

import java.util.HashMap;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(Integer[][] adjacencyMatrix, boolean isWeighted) {
        super(false, isWeighted);
        super.fromAdjacencyMatrix(adjacencyMatrix);
    }
    public UndirectedGraph(boolean isWeighted) {
        super(false, isWeighted);
        super.generateGraph();
    }

}
