import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFT {
    private int V;
    private LinkedList<Integer> adj[];
    
    public GraphDFT(int v) {
        this.V = v;
        this.adj = new LinkedList[v];

        for(int i=0; i<v; i++) {
            this.adj[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        this.adj[source].add(destination);
    }

    public void DFT(int source) {
        boolean visited[] = new boolean[this.V];

        traverse(visited, source);
    }

    public void traverse(boolean visited[], int currentNode) {
        visited[currentNode] = true;
        System.out.print(currentNode + " ");
        Iterator<Integer> iterator = this.adj[currentNode].listIterator();
        while(iterator.hasNext()) {
            int nextNode = iterator.next();
            if(!visited[nextNode]) traverse(visited, nextNode);
        }
    }

    public static void main(String args[]) {
        GraphDFT graph = new GraphDFT(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.DFT(1);

        System.out.println();

        GraphDFT graph1 = new GraphDFT(4);

        graph1.addEdge(2, 0);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(0, 1);
        graph1.addEdge(3, 3);
        graph1.addEdge(1, 3);
           
        graph1.DFT(2);
    }
}