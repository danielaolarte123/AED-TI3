package model;

import dataStructures.Graph;
import dataStructures.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class IcesiMap {

    private final String SEPARATOR = ";";
    private final String FILENAME = "data/adjacency_list_map.csv";

    private Graph<Place> map;

    public IcesiMap () throws IOException {
        map = new Graph<>();
        importData();
    }

    private void addPlace (Place newPlace) {
        map.insertVertex(newPlace);
    }

    private boolean deletePlace (Place placeToDelete) {
        return map.delete(placeToDelete);
    }

    private void insertAdjacent (String rowOfAdjacent) {
        String [] adjacent = rowOfAdjacent.split(SEPARATOR);
        Place mainPlace = new Place(adjacent[0]);
        if (map.searchVertex(mainPlace) == null)
            addPlace(mainPlace);
        for (int i = 1; i < adjacent.length; i+=2) {
            Place adjacentPlace = new Place(adjacent[i + 1]);
            int cost = Integer.parseInt(adjacent[i]);
            if (map.searchVertex(adjacentPlace) == null)
                addPlace(adjacentPlace);
            map.insertEdge(mainPlace,adjacentPlace, cost);
        }
    }

    public void importData () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader((FILENAME)));
        String line = br.readLine();
        while (line != null) {
            insertAdjacent(line);
            line = br.readLine();
        }
        br.close();
    }

    public String lowerCostPath (Vertex<Place> initialPlace, Vertex<Place> finalPlace) {
        Stack<Vertex<Place>> lowerCostPathStack = map.dijkstra(initialPlace, finalPlace);
        Vertex<Place> [] lowerCostPathArray = (Vertex<Place>[]) lowerCostPathStack.toArray();

        String message = "";
        for (Vertex<Place> place : lowerCostPathArray) {
            message += place.toString() + "\n";
        }
        return message;
    }
}
