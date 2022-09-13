package components.graph;

import components.edge.DirectedEdge;
import components.edge.Edge;
import components.edge.UndirectedEdge;
import components.vertex.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.*;

public abstract class Graph {

    private HashMap<Integer, Vertex> vertices;
    private List<Edge> edges;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph(boolean isDirected, boolean isWeighted) {
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public void fromAdjacencyMatrix(Integer[][] adjacencyMatrix) {
        int matrixSize = adjacencyMatrix.length;
        Vertex fromVertex;
        Vertex toVertex;
        Edge edge;

        this.vertices.clear();
        this.edges.clear();

        for (int from = 0; from < matrixSize; from++) {
            fromVertex = makeVertex(from);
            for (int to = 0; to < matrixSize; to++) {
                toVertex = makeVertex(to);
                if (adjacencyMatrix[from][to] == 0)
                    continue;
                fromVertex.addNeighbor(toVertex);

                if ((!isDirected) && (from > to))
                    continue;
                if (isDirected) {
                    edge = new DirectedEdge(fromVertex, toVertex);
                } else {
                    edge = new UndirectedEdge(fromVertex, toVertex);
                }
                if (isWeighted) {
                    edge.setWeight(adjacencyMatrix[from][to]);
                }
                edges.add(edge);
            }
        }
    }
    private Vertex makeVertex(int id) {
        Vertex v;
        if (vertices.containsKey(id)) {
            v = vertices.get(id);
        } else {
            v = new Vertex(id);
            vertices.put(id, v);
        }
        return v;
    }

    public Edge findEdge(Vertex v1, Vertex v2) {
        Vertex[] ends;
        for (Edge e : edges) {
            ends = e.getEnds();
            if ((ends[0].equals(v1) && ends[1].equals(v2)) || (ends[0].equals(v2) && ends[1].equals(v1)))
                return e;
        }
        return null;
    }

    public void printGraph() {
        for (Vertex v : vertices.values()) {
            System.out.println(v + " (" + v.getLayoutX() + ", " + v.getLayoutY() + ")" + ": " + v.getNeighbors());
        }
        System.out.println();

        for (Edge e : edges) {
            System.out.println(e);
        }
    }

    public HashMap<Integer, Vertex> getVertices() {
        return vertices;
    }

    public void generateGraph() {
        Random r = new Random();
        int size = r.nextInt(10);
        Integer[][] matrix = new Integer[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = r.nextInt();
            }
        }

        fromAdjacencyMatrix(matrix);
        setAutoPosition();
    }
    public void setAutoPosition() {
        double degree = (2 * Math.PI) / vertices.size();
        double radius = 200.0;

        double x, y;
        for (int i = 0; i < vertices.size(); i++) {
            x = Math.cos(degree * i) * radius + 270;
            y = Math.sin(degree * i) * radius + 290;
            vertices.get(i).setLayout(x, y);

            System.out.println("i = " + i + ", cos(" + (degree * i) + ") = " + Math.cos(degree*i));
            System.out.println("x = " + x + ", y = " + y);
            System.out.println(vertices.get(i) + ": (" + vertices.get(i).getLayoutX() + ", " + vertices.get(i).getLayoutY() + ")");
        }
    }
}
