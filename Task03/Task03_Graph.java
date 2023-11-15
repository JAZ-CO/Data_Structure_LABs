package Task03;

import java.util.*;

// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
    private List<List<Integer>> adjList = null;
    private int numVertices;
 
    public Graph(List<Edge> edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
 
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge edge: edges){
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
        }
    }
  
    public boolean isReachable(int src, int dest){
      boolean[] visited = new boolean[numVertices];
      return isReachable(src, dest, visited);
    }
    
    // Function to perform BFS traversal from the source vertex in the graph to
    // determine if the destination vertex is reachable from the source or not
    private boolean isReachable(int src, int dest, boolean[] visited)
    {
       // to be completed by students
        //if the source is the same as destination
        if (src == dest)
            return true;

        // queue of linked list in order to store more than one element in certain position
        Queue<Integer> queue = new LinkedList<>();

        for (int neighbor : adjList.get(src)) {
            // is the vertex has not been visited before, add it to queue
            if(!visited[neighbor]){
                queue.add(neighbor);

                while(!queue.isEmpty()){
                    if (queue.peek() == dest)
                        return true;


                    //get a vertex from queue
                    int vertex = queue.remove();
                    //mark the vertex visited
                    visited[vertex] = true;

                    //add unvisited adjacent vertices
                        for (int j = 0; j < adjList.get(vertex).size(); j++){

                            int adjVertex = adjList.get(vertex).get(j);
                            if (!visited[adjVertex]) {
                                visited[adjVertex] = true;
                                queue.add(adjVertex);
                            }
                        }
                }
            }
        }
        return false;
    }
}
