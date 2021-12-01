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

    public IcesiMap() throws IOException {
        map = new Graph<>();
        importData();
       
    }

    private void addPlace(Place newPlace) {
        map.insertVertex(newPlace);
    }

    private void insertAdjacent(String rowOfAdjacent) {
        String[] adjacent = rowOfAdjacent.split(SEPARATOR);
        Place mainPlace = new Place(adjacent[0]);
        if (map.searchVertex(mainPlace) == null){
            addPlace(mainPlace);
        }

        for (int i = 1; i < adjacent.length; i += 2) {
            Place adjacentPlace = new Place(adjacent[i + 1]);
            int cost = Integer.parseInt(adjacent[i]);
            if (map.searchVertex(adjacentPlace) == null){
                addPlace(adjacentPlace);
            }
            if(map.searchVertex(mainPlace).searchEdge(map.searchVertex(adjacentPlace))==null){
                map.insertEdge(mainPlace, adjacentPlace, cost);
            }
            
        }
    }

    public void importData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader((FILENAME)));
        String line = br.readLine();
        while (line != null) {
            insertAdjacent(line);
            line = br.readLine();
        }
        br.close();
    }

    public ArrayList<String> lowerCostPath(Place initialPlace, Place finalPlace) {
        ArrayList<String> message = new ArrayList<>();

        Vertex<Place> start = map.searchVertex(initialPlace);
        Vertex<Place> end = map.searchVertex(finalPlace);
        Stack<Vertex<Place>> lowerCostPathStack = map.dijkstra(start, end);

        for (Vertex<Place> place : lowerCostPathStack) {
            message.add(place.getItem().getName());
        }
        return message;
    }

    public ArrayList<String> getPlaces() {
        ArrayList<String> places = new ArrayList<String>();
        map.getVertices().forEach(element -> places.add(element.getItem().getName()));
        return places;
    }
}
