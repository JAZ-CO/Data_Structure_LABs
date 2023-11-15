package Task03;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Edge> edges = Arrays.asList(Edge.getEdge(0, 3),  Edge.getEdge(1, 0),
                                             Edge.getEdge(1, 2),  Edge.getEdge(1, 4),
                                             Edge.getEdge(2, 7),  Edge.getEdge(3, 4),
                                             Edge.getEdge(3, 5), Edge.getEdge(4, 3),
                                             Edge.getEdge(4, 6), Edge.getEdge(5, 6),
                                             Edge.getEdge(6, 7));
 
        // Number of nodes in the graph (labelled from 0 to N-1)
        int numVertices = 8;
        // To be completed by students
        Graph graph = new Graph(edges, 8);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the source vertex [0 - 7]: ");
        int src = input.nextInt();
        System.out.print("Enter the destination vertex [0 - 7]: ");
        int dest = input.nextInt();

        if (graph.isReachable(src,dest))
            System.out.println("Path exists between vertices " + src + " and " + dest);
        else
            System.out.println("no path exists from vertex " + src + " to vertex " + dest);
    }
}