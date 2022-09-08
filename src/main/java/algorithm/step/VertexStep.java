package algorithm.step;

import components.vertex.Vertex;

public class VertexStep extends DetailedStep {

    public VertexStep (int pseudoStepId, String content) {
        super(content);
        this.pseudoStepId = pseudoStepId;
    }
}
