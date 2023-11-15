package LabTask02;

import java.util.*;

class Graph {
    int numVertices;
    LinkedList<String>[] adjacencyList;
    String[] labels;

    Graph(int numVertices, String[] labels) {
        this.labels =  labels;

        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new LinkedList<String>();
    }


    //To add a directed edge to graph
    void addDirectedEdge(int v, int w)  {
        // To be completed by students
        adjacencyList[v].add(this.labels[w]); // Add w to v’s list.
    }
    //To add undirected edge to graph
    void addUndirectedEdge(int v, int w) {
        // to be completed by students
        // instead of adding the number directly, we add the letter that represents it
        adjacencyList[v].add(this.labels[w]);
        adjacencyList[w].add(this.labels[v]);
    }
    void displayGraph(){
        // to be completed by students
        for (int i = 0; i < adjacencyList.length; i++){
            System.out.println(i + " ----> " + adjacencyList[i]);
        }
        System.out.println();
    }

}

