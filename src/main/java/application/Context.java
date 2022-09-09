package application;

import algorithm.Algorithm;

public class Context {

    private Algorithm algorithm;
    private Controller controller;

    public void run() {
        algorithm.execute();
        controller.displaySteps(algorithm.getPseudoStepList(), algorithm.getDetailedStepList());
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
