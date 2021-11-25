package dataStructures;

import java.util.*;

public interface IGraph<V> {

    public void insertVertex(V item);

    public Vertex<V> searchVertex(V item);

    public boolean insertEdge(V item1, V item2,int cost);

    public ArrayList<Vertex<V>> getVertices();

    public void setVertices(ArrayList<Vertex<V>> vertices);

    public boolean delete(V item);

    public Stack<Vertex<V>> dijkstra (Vertex initialVertex, Vertex finalVertex);

    public String toString();

}

