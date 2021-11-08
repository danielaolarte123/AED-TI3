package dataStructures;

public class Edge<V>{

    private Vertex<V> vertex1;
    private Vertex<V> vertex2;
    private int cost;


    public Edge(Vertex<V> vertex1, Vertex<V> vertex2, int cost) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.cost = cost;
    }





    public Vertex<V> getVertex1() {
        return this.vertex1;
    }

    public void setVertex1(Vertex<V> node1) {
        this.vertex1 = node1;
    }

    public Vertex<V> getVertex2() {
        return this.vertex2;
    }

    public void setVertex2(Vertex<V> node2) {
        this.vertex2 = node2;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }



}
