package algorithm.step;

import components.edge.Edge;

public class EdgeStep extends DetailedStep {

    private Edge edge;

    public EdgeStep (int pseudoStepId, Edge edge, String content) {
        super(content);
        this.pseudoStepId = pseudoStepId;
        this.edge = edge;
    }
}
