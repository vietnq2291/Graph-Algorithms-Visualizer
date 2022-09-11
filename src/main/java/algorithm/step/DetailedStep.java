package algorithm.step;

import javafx.geometry.Insets;

public class DetailedStep extends PseudoStep {

    protected int pseudoStepId;

    public DetailedStep(int pseudoStepId, String content) {
        super(content);
        this.pseudoStepId = pseudoStepId;
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: rgb(167, 212, 30)");
    }

    public int getPseudoStepId() {
        return pseudoStepId;
    }

    public void setPseudoStepId(int pseudoStepId) {
        this.pseudoStepId = pseudoStepId;
    }
}
