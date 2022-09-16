package algorithm.step;

import components.status.Status;
import components.vertex.Vertex;

public class VertexStep extends DetailedStep implements Activable {

    private Vertex vertex;
    private Status status;

    public VertexStep (int pseudoStepId, Vertex vertex, Status status, String content) {
        super(pseudoStepId, content);
        this.vertex = vertex;
        this.status = status;
    }

    public void setActive() {
        vertex.setVertexStyle(Status.VISITING);
    }
    public void setInactive() {
        vertex.setVertexStyle(status);
    }
}
