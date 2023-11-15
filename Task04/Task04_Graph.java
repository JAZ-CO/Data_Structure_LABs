package Task04;

public class Graph {
        private int numVertices;
        private int matrix[][];

        public Graph(int numVertices) {
            this.numVertices = numVertices;
            matrix = new int[numVertices][numVertices];
        }

        public void addDirectedEdge(int source, int destination, int weight) {
            //add edge
            matrix[source][destination] = weight;

            //add back edge for undirected graph
           // matrix[destination][source] = weight;
        }

        //get the vertex with minimum distance which is not included in SPT
        private int getMinimumVertex(boolean [] mst, int [] key){
            int minKey = Integer.MAX_VALUE;
            int vertex = 0;   
            for (int i = 0; i < numVertices ; i++) {
                if(mst[i] == false && minKey > key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        public void dijkstra_GetMinDistances(int sourceVertex){
            boolean[] spt = new boolean[numVertices];
            int [] distance = new int[numVertices];
            int INFINITY = Integer.MAX_VALUE;

            //Initialize all the distance to infinity
            for (int i = 0; i < numVertices ; i++) {
                distance[i] = INFINITY;
            }

            //start from the source vertex
            distance[sourceVertex] = 0;

            //create SPT
            for (int i = 0; i < numVertices ; i++) {

                //get the vertex with the minimum distance
                int vertex_U = getMinimumVertex(spt, distance);
                
                //include this vertex in SPT
                spt[vertex_U] = true;

                //iterate through all the adjacent vertices of above vertex and update the keys
                for (int vertex_V = 0; vertex_V < numVertices ; vertex_V++) {
                    //check of the edge between vertex_U and vertex_V
                    if(matrix[vertex_U][vertex_V] > 0){
                        //check if this vertex 'vertex_V' already in spt and
                        // if distance[vertex_V]!=Infinity

                        if(spt[vertex_V] == false && matrix[vertex_U][vertex_V] != INFINITY){
                            //check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance

                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                                distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            //print shortest path tree
            for(int k = 0; k < distance.length; k++)     // sometimes -ve values returned if there is no path 
                distance[k] = Math.abs(distance[k]);
                
            printDijkstra(sourceVertex, distance);
        }

        public void printDijkstra(int sourceVertex, int [] key){
            System.out.println("Dijkstra Algorithm: Shortest paths from vertex " + sourceVertex +":");
            for (int i = 0; i < numVertices ; i++) {
			     if(key[i] >2000000000)
                System.out.printf("Source Vertex: %d to vertex %d shortest distance: %f %n", sourceVertex, i, Double.POSITIVE_INFINITY);  // 8734
			     else
			       System.out.println("Source Vertex: " + sourceVertex + " to vertex " + i + " distance: " + key[i]);
            }
        }
    }