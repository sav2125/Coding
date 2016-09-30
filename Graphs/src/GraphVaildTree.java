import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by siddharthvarshney on 9/27/16.
 */
public class GraphVaildTree {
    private int V;
    ArrayList<Integer> [] adj;
    GraphVaildTree(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < this.V; i++)
        {
            adj[i] = new ArrayList<Integer>();
        }
    }
    void addEdge(int u, int v)
    {
        adj[u].add(v);
        adj[v].add(u);
    }
    boolean isCycleUtil(boolean[] visited, int u, int parent)
    {
        visited[u] = true;
        Iterator<Integer> it = adj[u].iterator();
        while(it.hasNext())
        {
            int v = it.next();
            if(visited[v] == false)
            {
                if(isCycleUtil(visited, v , u) == true)
                    return true;
            }
            else if (parent != v)
            {
                return true;
            }
        }
        return false;
    }
    boolean isValidTree()
    {
        boolean visited[] = new boolean[this.V];
        for(int i = 0; i < this.V;i++)
        {
            visited[i] = false;

        }
        for(int i = 0; i < this.V; i++)
        {
            if(visited[i] == false)
            {
                if(isCycleUtil(visited, i, -1) == true)
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        GraphVaildTree g = new GraphVaildTree(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,4);
        System.out.println(g.isValidTree());
        GraphVaildTree g2 = new GraphVaildTree(5);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(2,3);
        g2.addEdge(1,3);
        g2.addEdge(1,4);
        System.out.println(g2.isValidTree());
    }
}
