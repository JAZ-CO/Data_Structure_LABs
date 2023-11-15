package Task04;

public class DijkstraAdjacencyMatrixDriver {
    public static void main(String[] args) {
        // to be completed by students
        Graph graph = new Graph(8);

        graph.addDirectedEdge(6,1,8);
        graph.addDirectedEdge(6,0,2);
        graph.addDirectedEdge(0,1,4);
        graph.addDirectedEdge(0,2,6);
        graph.addDirectedEdge(1,3,5);
        graph.addDirectedEdge(1,2,1);
        graph.addDirectedEdge(2,7,9);
        graph.addDirectedEdge(2,3,2);
        graph.addDirectedEdge(2,4,8);
        graph.addDirectedEdge(3,4,2);
        graph.addDirectedEdge(4,7,3);
        graph.addDirectedEdge(5,4,10);

        graph.dijkstra_GetMinDistances(6);
    }
}
