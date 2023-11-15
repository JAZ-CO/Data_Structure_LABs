package test;

public class GraphDriver {
    // Driver program to test methods of graph class 
    public static void main(String[] args)  { 

        // STUDENT TEST:
        Graph g = new Graph(4);
       g.addEdge(0,3);
       g.addEdge(0,2);
       g.addEdge(0,1);
       g.addEdge(1,3);
       g.addEdge(2,3);
        System.out.println("Before deleting edge 2---3 the graph is:  ");
        g.displayGraph();

        g.removeEdge(2,3);
        System.out.println("After deleting edge 2---3 the graph is:  ");
        g.displayGraph();

    } 
} 
