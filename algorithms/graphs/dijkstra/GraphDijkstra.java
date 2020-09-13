public class GraphDijkstra {
    static final int V = 9;

    int minDistance(boolean sptSet[], int distance[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int i=0; i<V; i++) {
            if(!sptSet[i] && distance[i] <= min) {
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void printSolution(int distance[]) {
        System.out.println("Vertex \t \t Distance from source");
        for(int i=0; i<V; i++) {
            System.out.println(i + " \t \t " + distance[i]);
        }
    }

    void dijkstra(int graph[][], int source) {
        boolean sptSet[] = new boolean[V];
        int distance[] = new int[V];

        for(int i=0; i<V; i++) {
            sptSet[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        
        distance[source] = 0;

        for(int count=0; count<V-1; count++) {
            int u = minDistance(sptSet, distance);

            sptSet[u] = true;

            for(int v=0; v<V; v++) {
                if(!sptSet[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE 
                    && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance);
    }

    public static void main(String args[]) {
        int graph[][] = new int[][] { 
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
        };
        
        GraphDijkstra shortestPath = new GraphDijkstra();
        shortestPath.dijkstra(graph, 0);
    }
}