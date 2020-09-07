import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        this.adj[source].add(destination);
    }

    public void BFT(int start) {
        boolean visited[] = new boolean[this.V];
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");
            visited[currentNode] = true;
            Iterator<Integer> iterator = adj[currentNode].listIterator();
            while(iterator.hasNext()) {
                int nextVertex = iterator.next();
                if(!visited[nextVertex]) {
                    queue.add(nextVertex);
                }
            }
        }
    }
    
    public static void main(String args[]) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.BFT(2);
    }
}