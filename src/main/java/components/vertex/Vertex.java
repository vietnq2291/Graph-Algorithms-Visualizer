package components.vertex;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Vertex extends StackPane {

    private String CIRCLE_FREE_STYLE = "-fx-fill:white;-fx-stroke-width:2px;-fx-stroke:black;";
    private String CIRCLE_SELECTED_STYLE = "-fx-fill:green;-fx-stroke-width:2px;-fx-stroke:black;";
    private String CIRCLE_FINISHED_STYLE = "-fx-fill:orange;-fx-stroke-width:2px;-fx-stroke:black;";

    private static double radius = 20;

    private int name;
    private List<Vertex> neighbors;
    private Circle circle = new Circle();

    public Vertex(int name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        makeShape();
    }
    public Vertex(int name, double layoutX, double layoutY) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        setLayout(layoutX, layoutY);
        makeShape();
    }

    private void makeShape() {
        double paneSize = 2 * radius;

        // Set display of Vertex as Circle with name as Label
        circle = new Circle();
        circle.setRadius(radius);
        setVertexFreeStyle();

        Label txt = new Label(String.valueOf(this.name));
        txt.setStyle("-fx-font-size:18px;-fx-font-weight:bold;");

        this.getChildren().addAll(circle, txt);

        this.setPrefSize(paneSize, paneSize);
        this.setMaxSize(paneSize, paneSize);
        this.setMinSize(paneSize, paneSize);
    }

    public void addNeighbor(Vertex v) {
        if (!neighbors.contains(v)) {
            this.neighbors.add(v);
        }
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex v = (Vertex) o;
            return this.name == v.name;
        } else {
            return false;
        }
    }

    public void setVertexSelectedStyle() {
        circle.setStyle(CIRCLE_SELECTED_STYLE);
    }

    public void setVertexFinishedStyle() {
        circle.setStyle(CIRCLE_FINISHED_STYLE);
    }

    public void setVertexFreeStyle() {
        circle.setStyle(CIRCLE_FREE_STYLE);
    }

    public void setLayout(double layoutX, double layoutY) {
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
    }
    @Override
    public String toString() {
        return "(" + name + ")";
    }
}
