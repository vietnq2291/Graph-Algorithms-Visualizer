package algorithm.step;

public class DetailedStep extends PseudoStep {

    protected int pseudoStepId;

    public DetailedStep(String content) {
        super(content);
    }

    public int getPseudoStepId() {
        return pseudoStepId;
    }

    public void setPseudoStepId(int pseudoStepId) {
        this.pseudoStepId = pseudoStepId;
    }
}
