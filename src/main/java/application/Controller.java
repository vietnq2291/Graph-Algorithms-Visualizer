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
    int currentStepId;



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        stepProgress.setProgress(0);
        currentStepId = 0;
    }

    public void goToNextStep() {
        ObservableList<Node> children = detailedStepDisplay.getChildren();

        if (currentStepId < detailedStepDisplay.getChildren().size()-1) {
            currentStepId++;
            DetailedStep previousTop = (DetailedStep) children.get(children.size()-1);
            previousTop.toBack();
            DetailedStep currentTop = (DetailedStep) children.get(children.size()-1);

            stepProgress.setProgress(currentStepId * progressIncrement);
            showNewPseudoStep(previousTop, currentTop);
        }
    }
    public void goToPreviousStep() {
        ObservableList<Node> children = detailedStepDisplay.getChildren();

        if (currentStepId > 0) {
            currentStepId--;
            DetailedStep previousTop = (DetailedStep) children.get(children.size()-1);
            children.get(0).toFront();
            DetailedStep currentTop = (DetailedStep) children.get(children.size()-1);

            stepProgress.setProgress(currentStepId * progressIncrement);
            showNewPseudoStep(previousTop, currentTop);
        }
    }

    private void showNewPseudoStep(DetailedStep previousTop, DetailedStep currentTop) {
        PseudoStep previousPseudoStep = (PseudoStep) pseudoStepsDisplay.getChildren().get(previousTop.getPseudoStepId());
        PseudoStep currentPseudoStep = (PseudoStep) pseudoStepsDisplay.getChildren().get(currentTop.getPseudoStepId());

        previousPseudoStep.setStyleInactive();
        currentPseudoStep.setStyleActive();
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
        ((PseudoStep) pseudoStepsDisplay.getChildren().get(0)).setStyleActive();
    }
}