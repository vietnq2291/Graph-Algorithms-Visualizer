package algorithm.step;

import javafx.scene.control.Label;

public class PseudoStep extends Label {


    public PseudoStep(String content) {
        this.setText(content);
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
