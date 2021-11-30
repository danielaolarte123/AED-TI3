package dataStructures;

import java.util.*;

public class Graph<V> implements IGraph<V>{

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
    public Stack<Vertex<V>> dijkstra(Vertex initialVertex, Vertex finalVertex) {
        PriorityQueue<Vertex<V>> distances = new PriorityQueue<>(vertices.size(), new Comparator<Vertex<V>>() {
            @Override
            public int compare(Vertex<V> o1, Vertex<V> o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        initialVertex.setDistance(0);
        for (Vertex vertex : vertices) {
            if (vertex != initialVertex)
                vertex.setDistance(Integer.MAX_VALUE);
            vertex.setPrev(null);
            distances.add(vertex);
        }
        while (!distances.isEmpty()) {
            Vertex<V> u = distances.poll();
            for (Vertex<V> v : u.adjacency()) {
                int alt = u.getDistance() + length(u,v);    //TODO complete length method
                if (alt < v.getDistance()) {
                    v.setDistance(alt);
                    v.setPrev(u);
                }
            }
        }
        Stack<Vertex<V>> path = new Stack<>();
        Vertex<V> target = finalVertex;
        if (target.getPrev() != null || target == initialVertex) {
            while (target != null) {
                path.push(target);
                target = target.getPrev();
            }
        }
        return path;
    }

    private int length(Vertex<V> u, Vertex<V> v) {
        return u.searchEdge(v).getCost();
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
