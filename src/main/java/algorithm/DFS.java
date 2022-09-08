package algorithm;

import algorithm.step.DetailedStep;
import algorithm.step.EdgeStep;
import algorithm.step.PseudoStep;
import algorithm.step.VertexStep;
import components.vertex.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS extends Algorithm {

    private List<Vertex> visited;

    public DFS() {
        buildPseudoSteps();
    }

    private void buildPseudoSteps() {
        pseudoStepList.put(1, new PseudoStep("traverse(graph):"));
        pseudoStepList.put(2, new PseudoStep("  for each v in graph:"));
        pseudoStepList.put(3, new PseudoStep("    if v is not visited, DFS(v)"));
        pseudoStepList.put(4, new PseudoStep("DFS(v):"));
        pseudoStepList.put(5, new PseudoStep("  set v as visited"));
        pseudoStepList.put(6, new PseudoStep("  for each neighbor u of v:"));
        pseudoStepList.put(7, new PseudoStep("    if u is not visited, DFS(u)"));
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
        detailedStepList.put(detailedStepList.size(), new VertexStep(4, "DFS " + v));

        visited.add(v);
        detailedStepList.put(detailedStepList.size(), new VertexStep(5, "Set " + v + " as visited"));

        for (Vertex u : v.getNeighbors()) {
            detailedStepList.put(detailedStepList.size(), new EdgeStep(6, "Try edge " + v + " → " + u));
            if (!visited.contains(u)) {
                detailedStepList.put(detailedStepList.size(), new VertexStep(7, u + " is not visited"));
                detailedStepList.put(detailedStepList.size(), new EdgeStep(7,"Add edge " + v + " ---→ " + u));
                recursiveDFS(u);
            } else {
                detailedStepList.put(detailedStepList.size(), new VertexStep(7, u + " has already been visited"));
            }
        }
    }

    public void print() {
        Scanner sc = new Scanner(System.in);
        DetailedStep step;
        int cmd;
        int index = 0;
        while (true) {
            cmd = sc.nextInt();
            if (cmd == 0) {
                index -= 1;
            } else {
                index += 1;
            }
            step = detailedStepList.get(index);
            System.out.println(pseudoStepList.get(step.getPseudoStepId()));
            System.out.println("===" +  detailedStepList.get(index));

        }
    }

}
