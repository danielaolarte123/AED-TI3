package dataStructures;

import java.util.ArrayList;

public class Vertex<V> {

    private V item;
    private ArrayList<Edge<V>> edges;

    public Vertex(V item) {
        this.item = item;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge<V> edge) {
        edges.add(edge);
    }

    public V getItem() {
        return this.item;
    }

    public void setItem(V item) {
        this.item = item;
    }

    public ArrayList<Edge<V>> getEdges() {
        return this.edges;
    }

    public void setEdges(ArrayList<Edge<V>> edges) {
        this.edges = edges;
    }

    private Vertex<V> compareEdge(Edge<V> edge) {

        if (this != edge.getVertex1()) {
            return edge.getVertex1();
        } else if (this != edge.getVertex2()) {
            return edge.getVertex2();
        } else
            return null;
    }

    @Override
    public String toString() {
        String msg = "ITEM: " + getItem() + "| ";
        for (Edge<V> edge : edges) {
            Vertex<V> vertex = compareEdge(edge);

            if (vertex == null) {
                msg += " -> " + edge.getVertex1().getItem();
            } else {
                msg += " -> " + vertex.getItem();
            }

        }

        return msg;
    }

    public void delete() {

        for (Edge<V> edge : edges) {

            Vertex<V> vertex = compareEdge(edge);
            if (vertex != null) {
                vertex.getEdges().remove(edge);
            }

        }
    }

}
