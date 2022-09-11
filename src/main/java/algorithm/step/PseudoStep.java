package algorithm.step;

import javafx.scene.control.Label;

public class PseudoStep extends Label {


    public PseudoStep(String content) {
        this.setText(content);
        this.setStyleInactive();
        this.setMaxWidth(Double.MAX_VALUE);
    }

    @Override
    public String toString() {
        return this.getText();
    }

    public void setStyleActive() {
        this.setStyle("-fx-background-color: rgb(255, 138, 39)");
    }

    public void setStyleInactive() {
        this.setStyle("-fx-background-color: rgb(254, 197, 21);");
    }
}
