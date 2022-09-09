package application;

import algorithm.step.DetailedStep;
import algorithm.step.PseudoStep;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private List<Label> pseudoTextList;
    @FXML
    private VBox pseudoStepsDisplay;

    @FXML
    public void initialize(URL location, ResourceBundle resources) { }

    public void displaySteps(List<PseudoStep> pseudoStepList, List<DetailedStep> detailedStepList) {
        int lineHeight = (int) (pseudoStepsDisplay.getHeight()) / pseudoStepList.size();

        for (PseudoStep step : pseudoStepList) {
            step.setPrefHeight(lineHeight);
            pseudoTextList.add(step);
            pseudoStepsDisplay.getChildren().add(step);
        }
    }
}