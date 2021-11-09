package dataStructures;

import java.util.ArrayList;

public class Graph<V> {

    private ArrayList<Vertex<V>> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void insertVertex(V item) {
        Vertex<V> vertex = new Vertex<V>(item);

        vertices.add(vertex);

    }

    public Vertex<V> searchVertex(V item) {
        for (Vertex<V> vertex : vertices) {
            if (item.equals(vertex.getItem())) {
                return vertex;
            }

        }
        return null;
    }

    public boolean insertEdge(V item1, V item2,int cost) {
        boolean insert=true;

        Vertex<V> vertex1 = searchVertex(item1);
        Vertex<V> vertex2 = searchVertex(item2);
        Edge<V> edge = new Edge<>(vertex1, vertex2, cost);

        if (vertex1 == null && vertex2==null) {
            insert=false;
        } else if (vertex1 ==vertex2 ) {
            vertex1.addEdge(edge);
        }else{
            vertex1.addEdge(edge);
            vertex2.addEdge(edge);
            
        }

        return insert;

    }

    public ArrayList<Vertex<V>> getVertices() {
        return this.vertices;
    }

    public void setVertices(ArrayList<Vertex<V>> vertices) {
        this.vertices = vertices;
    }

    public boolean delete(V item){
        Vertex<V> vertex=searchVertex(item);
        boolean delete=false;

        if (vertex !=null){
            vertices.remove(vertex);
            vertex.delete();
            delete=true;
        }

       return delete;
       
    }

    @Override
    public String toString() {
        String msg = "Adjacency list";
        for (Vertex<V> vertex : vertices) {
            msg += "\n" + vertex;
        }
        msg += "\n--------------------";
        return msg;
    }

}
