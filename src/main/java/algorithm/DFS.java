package algorithm;

import algorithm.step.EdgeStep;
import algorithm.step.PseudoStep;
import algorithm.step.VertexStep;
import components.edge.Edge;
import components.vertex.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DFS extends Algorithm {

    private List<Vertex> visited;

    public DFS() {
        buildPseudoSteps();
    }

    private void buildPseudoSteps() {
        pseudoStepList.add(new PseudoStep("traverse(graph):"));
        pseudoStepList.add(new PseudoStep("\tfor each v in graph:"));
        pseudoStepList.add(new PseudoStep("\t\tif v is not visited, DFS(v)"));
        pseudoStepList.add(new PseudoStep("DFS(v):"));
        pseudoStepList.add(new PseudoStep("\tset v as visited"));
        pseudoStepList.add(new PseudoStep("\tfor each neighbor u of v:"));
        pseudoStepList.add(new PseudoStep("\t\tif u is not visited, DFS(u)"));
    }

    public void execute() {
        visited = new ArrayList<>();
        for (Vertex v : this.getGraph().getVertices().values()) {
            if (!visited.contains(v)) {
                recursiveDFS(v);
            }
        }
    }
    private void recursiveDFS(Vertex v) {
        detailedStepList.add(new VertexStep(4, v, "DFS " + v));

        visited.add(v);
        detailedStepList.add(new VertexStep(5, v, "Set " + v + " as visited"));

        for (Vertex u : v.getNeighbors()) {
            Edge e = this.getGraph().findEdge(u, v);
            detailedStepList.add(new EdgeStep(6,  e, "Try edge " + e));
            if (!visited.contains(u)) {
                detailedStepList.add(new VertexStep(7, u, u + " is not visited"));
                detailedStepList.add(new EdgeStep(7, e, "Add edge " + e));
                recursiveDFS(u);
            } else {
                detailedStepList.add(new VertexStep(7, u,u + " has already been visited"));
            }
        }
    }

//    public void print() {
//        Scanner sc = new Scanner(System.in);
//        DetailedStep step;
//        int cmd;
//        int index = 0;
//        while (true) {
//            cmd = sc.nextInt();
//            if (cmd == 0) {
//                index -= 1;
//            } else {
//                index += 1;
//            }
//            step = detailedStepList.get(index);
//            System.out.println(pseudoStepList.get(step.getPseudoStepId()));
//            System.out.println("=== " +  detailedStepList.get(index));
//
//        }
//    }

}
