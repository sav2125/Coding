import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by siddharthvarshney on 9/10/16.
 */
public class DFS {
    private int V;
    private LinkedList<Integer> [] adj;
    DFS(int V)
    {
        this.V = V;
        adj = new LinkedList[this.V];
        for(int i = 0; i < this.V; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int u, int v)
    {
        adj[u].add(v);
    }
    void dFSUtil(int u, boolean [] visited)
    {
        System.out.print(u + " ");
        visited[u] = true;
        Iterator<Integer> it = adj[u].listIterator();
        while(it.hasNext())
        {
            int v = it.next();
            if(visited[v] == false)
                dFSUtil(v,visited);
        }
    }
    void dFS(int src)
    {
        boolean [] visited = new boolean[this.V];
        dFSUtil(src, visited);
    }
    public static void main(String args[])
    {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.dFS(2);
    }
}
