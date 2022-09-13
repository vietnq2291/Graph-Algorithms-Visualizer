package application;

import algorithm.DFS;
import components.graph.UndirectedGraph;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Controller controller = fxmlLoader.getController();
        stage.setTitle("Graph Algorithms Visualizer");
        stage.setScene(scene);
        stage.show();


        Integer[][] graph2 = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}
        };
        UndirectedGraph ug2 = new UndirectedGraph(graph2, true);
        ug2.printGraph();
        ug2.setAutoPosition();

        DFS dfs = new DFS();
        dfs.setGraph(ug2);

        Context context = new Context();
        context.setAlgorithm(dfs);
        context.setController(controller);
        context.run();





    }

    public static void main(String[] args) {
        launch();
    }
}