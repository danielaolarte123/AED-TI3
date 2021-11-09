package model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dataStructures.Edge;
import dataStructures.Graph;
import dataStructures.Vertex;

public class GraphTest {

    private Graph<String> graph;

    private void setupScenary1() {
        graph = new Graph<String>();
    }

    private void setupScenary2() {
        graph = new Graph<String>();
        graph.insertVertex("1");
        graph.insertVertex("2");
        graph.insertVertex("3");
        graph.insertVertex("4");
        graph.insertVertex("5");

        graph.insertEdge("1", "2", 1);
        graph.insertEdge("1", "3", 1);
        graph.insertEdge("2", "4", 1);
        graph.insertEdge("5", "1", 1);
        graph.insertEdge("5", "2", 1);
        graph.insertEdge("5", "3", 1);
        graph.insertEdge("5", "4", 1);

    }

    private void setupScenary3() {
        graph = new Graph<String>();
        graph.insertVertex("1");
        graph.insertVertex("2");
        graph.insertVertex("3");
        graph.insertVertex("4");
        graph.insertVertex("5");
        graph.insertVertex("6");
        graph.insertVertex("7");
        graph.insertVertex("8");
        graph.insertVertex("9");
        graph.insertVertex("10");
        graph.insertVertex("11");

        graph.insertEdge("1", "2", 1);
        graph.insertEdge("1", "3", 1);
        graph.insertEdge("2", "4", 1);

        graph.insertEdge("5", "1", 1);
        graph.insertEdge("5", "2", 1);
        graph.insertEdge("5", "3", 1);
        graph.insertEdge("5", "4", 1);

        graph.insertEdge("5", "6", 1);
        graph.insertEdge("5", "7", 1);
        graph.insertEdge("3", "6", 1);
        graph.insertEdge("4", "7", 1);
        graph.insertEdge("2", "9", 1);
        graph.insertEdge("9", "4", 1);
        graph.insertEdge("6", "7", 1);
        graph.insertEdge("6", "10", 1);
        graph.insertEdge("11", "7", 1);
        graph.insertEdge("9", "7", 1);
        graph.insertEdge("9", "11", 1);
        graph.insertEdge("10", "11", 1);
        graph.insertEdge("8", "6", 1);
        graph.insertEdge("8", "7", 1);
        graph.insertEdge("8", "10", 1);
        graph.insertEdge("8", "11", 1);

    }

    @Test
    public void insertVertexTest1() {

        setupScenary1();

        Vertex<String> vertex1 = graph.searchVertex("1");
        Vertex<String> vertex2 = graph.searchVertex("2");
        assertNull(vertex1);
        assertNull(vertex2);

    }

    @Test
    public void insertVertexTest2() {

        setupScenary2();

        Vertex<String> vertex1 = graph.searchVertex("1");
        Vertex<String> vertex2 = graph.searchVertex("2");
        Vertex<String> vertex3 = graph.searchVertex("3");
        Vertex<String> vertex4 = graph.searchVertex("4");
        Vertex<String> vertex5 = graph.searchVertex("5");

        assertNotNull(vertex1);
        assertNotNull(vertex2);
        assertNotNull(vertex3);
        assertNotNull(vertex4);
        assertNotNull(vertex5);

    }

    @Test
    public void insertVertexTest3() {

        setupScenary3();

        Vertex<String> vertex1 = graph.searchVertex("7");
        Vertex<String> vertex2 = graph.searchVertex("8");
        Vertex<String> vertex3 = graph.searchVertex("9");
        Vertex<String> vertex4 = graph.searchVertex("10");
        Vertex<String> vertex5 = graph.searchVertex("11");

        assertNotNull(vertex1);
        assertNotNull(vertex2);
        assertNotNull(vertex3);
        assertNotNull(vertex4);
        assertNotNull(vertex5);

    }

    @Test
    public void searchVertexTest() {
        setupScenary3();

        assertTrue(graph.searchVertex("4").getItem().equals("4"));
        assertTrue(graph.searchVertex("10").getItem().equals("10"));
        graph.delete("10");
        assertNull(graph.searchVertex("10"));
    }

    @Test
    public void insertEdgeTest1() {

        setupScenary1();
        boolean edge1 = graph.insertEdge("8", "7", 1);
        boolean edge2 = graph.insertEdge("8", "10", 1);
        boolean edge3 = graph.insertEdge("8", "11", 1);
        assertFalse(edge1);
        assertFalse(edge2);
        assertFalse(edge3);

    }

    @Test
    public void insertEdgeTest2() {

        setupScenary2();

        boolean edge = graph.insertEdge("3", "4", 1);
        assertTrue(edge);

        Vertex<String> vertex3 = graph.searchVertex("3");
        Vertex<String> vertex4 = graph.searchVertex("4");
        edge = false;
        for (Edge<String> edgeVertex3 : vertex3.getEdges()) {

            if (edgeVertex3.getVertex1() == vertex4 || edgeVertex3.getVertex2() == vertex4)
                edge = true;

        }

        assertTrue(edge);

    }

    @Test
    public void insertEdgeTest3() {

        setupScenary3();

        boolean edge = graph.insertEdge("10", "1", 1);
        assertTrue(edge);

        Vertex<String> vertex10 = graph.searchVertex("10");
        Vertex<String> vertex1 = graph.searchVertex("1");
        edge = false;
        for (Edge<String> edgeVertex1 : vertex1.getEdges()) {

            if (edgeVertex1.getVertex1() == vertex10 || edgeVertex1.getVertex2() == vertex10)
                edge = true;

        }

        assertTrue(edge);

    }

    @Test
    public void deleteVertexTest1() {

        setupScenary1();

        boolean delete = graph.delete("2");
        assertFalse(delete);

    }

    @Test
    public void deleteVertexTest2() {

        setupScenary2();

        boolean delete1 = graph.delete("1");
        boolean delete6 = graph.delete("6");
        assertTrue(delete1);
        assertFalse(delete6);

    }

    @Test
    public void deleteVertexTest3() {

        setupScenary3();

        boolean delete1 = graph.delete("1");
        boolean delete6 = graph.delete("6");
        assertTrue(delete1);
        assertTrue(delete6);

    }

}