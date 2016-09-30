import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by siddharthvarshney on 9/10/16.
 */
public class BFS {
    private int V;
    private LinkedList<Integer> [] adj;
    BFS(int V)
    {
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    void bFS(int src)
    {
        boolean visited [] = new boolean[this.V];
        visited[src] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        while(q.size() != 0)
        {
            int u = q.poll();
            System.out.print(u + " ");
            Iterator<Integer> it = adj[u].listIterator();
            while(it.hasNext())
            {
                int v = it.next();
                if(visited[v] == false) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
    public static void main(String args[])
    {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bFS(2);
    }
}
