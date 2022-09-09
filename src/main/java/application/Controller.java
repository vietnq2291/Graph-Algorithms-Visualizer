package application;

import algorithm.step.DetailedStep;
import algorithm.step.PseudoStep;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private List<Label> pseudoTextList;
    @FXML
    private VBox pseudoStepsDisplay;
    @FXML
    private StackPane detailedStepDisplay;
    @FXML
    private ProgressBar stepProgress;

    double progressIncrement;



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        stepProgress.setProgress(0);
    }

    public void goToNextStep() {
        ObservableList<Node> children = detailedStepDisplay.getChildren();
        double curProgess = stepProgress.getProgress();

        System.out.print(stepProgress.getProgress() + " -> ");

        if (curProgess <= 1) {
            children.get(children.size()-1).toBack();
            stepProgress.setProgress(curProgess + progressIncrement);
        }

        System.out.println(stepProgress.getProgress());
    }
    public void goToPreviousStep() {
        ObservableList<Node> children = detailedStepDisplay.getChildren();
        double curProgess = stepProgress.getProgress();

        System.out.print(stepProgress.getProgress() + " -> ");

        if (curProgess > 0) {
            children.get(0).toFront();
            stepProgress.setProgress(curProgess - progressIncrement);
        }

        System.out.println(stepProgress.getProgress());
    }

    public void displaySteps(List<PseudoStep> pseudoStepList, List<DetailedStep> detailedStepList) {
        int lineHeight = (int) (pseudoStepsDisplay.getHeight()) / pseudoStepList.size();
        progressIncrement = 1.0 / (detailedStepList.size() - 1);

        for (PseudoStep step : pseudoStepList) {
            step.setPrefHeight(lineHeight);
            pseudoTextList.add(step);
            pseudoStepsDisplay.getChildren().add(step);
        }

        Collections.reverse(detailedStepList);
        detailedStepDisplay.getChildren().addAll(detailedStepList);
        System.out.println("detail size = " + detailedStepDisplay.getChildren().size());
    }
}