package model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;

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
    
		
		graph.insertEdge("1", "2");
        graph.insertEdge("1", "3");
		graph.insertEdge("2", "4");


        graph.insertEdge("5", "1");
        graph.insertEdge("5", "2");
		graph.insertEdge("5", "3");
        graph.insertEdge("5", "4");

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
    
    graph.insertEdge("1", "2");
    graph.insertEdge("1", "3");
    graph.insertEdge("2", "4");


    graph.insertEdge("5", "1");
    graph.insertEdge("5", "2");
    graph.insertEdge("5", "3");
    graph.insertEdge("5", "4");

    graph.insertEdge("5", "6");
    graph.insertEdge("5", "7");
    graph.insertEdge("3", "6");
    graph.insertEdge("4", "7");
    graph.insertEdge("2", "9");
    graph.insertEdge("9", "4");
    graph.insertEdge("6", "7");
    graph.insertEdge("6", "10");
    graph.insertEdge("11", "7");
    graph.insertEdge("9", "7");
    graph.insertEdge("9", "11");
    graph.insertEdge("10", "11");
    graph.insertEdge("8", "6");
    graph.insertEdge("8", "7");
    graph.insertEdge("8", "10");
    graph.insertEdge("8", "11");
    


}


@Test
public void insertVertexTest1(){

    setupScenary1();

    Vertex<String> vertex1=graph.searchVertex("1");
    Vertex<String> vertex2=graph.searchVertex("2");
    assertNull(vertex1);
    assertNull(vertex2);

}



@Test
public void insertVertexTest2(){

    setupScenary2();

    Vertex<String> vertex1=graph.searchVertex("1");
    Vertex<String> vertex2=graph.searchVertex("2");
    Vertex<String> vertex3=graph.searchVertex("3");
    Vertex<String> vertex4=graph.searchVertex("4");
    Vertex<String> vertex5=graph.searchVertex("5");

    assertNotNull(vertex1);
    assertNotNull(vertex2);
    assertNotNull(vertex3);
    assertNotNull(vertex4);
    assertNotNull(vertex5);


}


@Test
public void insertVertexTest3(){

    setupScenary3();

    Vertex<String> vertex1=graph.searchVertex("7");
    Vertex<String> vertex2=graph.searchVertex("8");
    Vertex<String> vertex3=graph.searchVertex("9");
    Vertex<String> vertex4=graph.searchVertex("10");
    Vertex<String> vertex5=graph.searchVertex("11");

    assertNotNull(vertex1);
    assertNotNull(vertex2);
    assertNotNull(vertex3);
    assertNotNull(vertex4);
    assertNotNull(vertex5);

}









}