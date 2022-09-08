package application;

import algorithm.Algorithm;

public class Context {

    private Algorithm algorithm;

    public void run() {
        algorithm.execute();
        algorithm.print();
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
