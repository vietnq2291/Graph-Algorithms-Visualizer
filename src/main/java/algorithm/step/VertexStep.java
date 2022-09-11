package algorithm.step;

import components.vertex.Vertex;

public class VertexStep extends DetailedStep {

    private Vertex vertex;

    public VertexStep (int pseudoStepId, Vertex vertex, String content) {
        super(pseudoStepId, content);
        this.vertex = vertex;
    }
}
