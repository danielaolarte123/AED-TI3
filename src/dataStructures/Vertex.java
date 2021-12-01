package dataStructures;

import java.util.ArrayList;

public class Vertex<V> {

    private V item;
    private ArrayList<Edge<V>> edges;
    private int distance;
    private Vertex<V> prev;

    public Vertex(V item) {
        this.item = item;
        this.edges = new ArrayList<>();
        prev = null;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex<V> getPrev() {
        return prev;
    }

    public void setPrev(Vertex<V> prev) {
        this.prev = prev;
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

    public ArrayList<Vertex<V>> adjacency() {
        ArrayList<Vertex<V>> list = new ArrayList<>();
        for (Edge<V> edge : edges) {
            Vertex<V> vertex = compareEdge(edge);

            if (vertex == null) {
                list.add(edge.getVertex1());
            } else {
                list.add(vertex);
            }

        }

        return list;
    }

    public void delete() {

        for (Edge<V> edge : edges) {

            Vertex<V> vertex = compareEdge(edge);
            if (vertex != null) {
                vertex.getEdges().remove(edge);
            }

        }
    }

    public Edge<V> searchEdge(Vertex<V> vertex) {
        for (Edge<V> edge : edges) {
            if (edge.getVertex1() == vertex) {
                return edge;
            } else if (edge.getVertex2() == vertex) {
                return edge;
            }
        }
        return null;
    }

}
