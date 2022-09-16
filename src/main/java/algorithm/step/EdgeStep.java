package algorithm.step;

import components.edge.Edge;

public class EdgeStep extends DetailedStep {// implements Activable {

    private Edge edge;

    public EdgeStep (int pseudoStepId, Edge edge, String content) {
        super(pseudoStepId, content);
        this.edge = edge;
    }
}
