package components;

import algorithm.DFS;
import application.Context;
import components.graph.UndirectedGraph;

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

        Context context = new Context();
        context.setAlgorithm(dfs);
        context.run();


    }
}
