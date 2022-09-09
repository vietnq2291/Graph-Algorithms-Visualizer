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
    protected List<PseudoStep> pseudoStepList;
    protected List<DetailedStep> detailedStepList;

    public Algorithm() {
        pseudoStepList = new ArrayList<>();
        detailedStepList = new ArrayList<>();
    }

    public abstract void execute();

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public List<PseudoStep> getPseudoStepList() {
        return pseudoStepList;
    }

    public List<DetailedStep> getDetailedStepList() {
        return detailedStepList;
    }
}
