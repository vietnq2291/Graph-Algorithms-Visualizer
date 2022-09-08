package algorithm;

import algorithm.step.DetailedStep;
import algorithm.step.PseudoStep;
import components.graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Algorithm {

    private Graph graph;
    protected HashMap<Integer, PseudoStep> pseudoStepList;
    protected HashMap<Integer, DetailedStep> detailedStepList;

    public Algorithm() {
        pseudoStepList = new HashMap<>();
        detailedStepList = new HashMap<>();
    }

    public abstract void execute();
    public abstract void print(); // -----temp

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
