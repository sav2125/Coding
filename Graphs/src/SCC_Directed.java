import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by siddharthvarshney on 10/2/16.
 */
public class SCC_Directed {
    private int V;
    ArrayList<Integer> [] adj;
    SCC_Directed(int V)
    {
        this.V = V;
        adj = new ArrayList[this.V];
        for(int i = 0; i < this.V; i++)
        {
            adj[i] = new ArrayList<>();
        }
    }
    void addEdge(int u, int v)
    {
        adj[u].add(v);
    }
    SCC_Directed getTranspose()
    {
        SCC_Directed g = new SCC_Directed(this.V);
        for(int v = 0; v < this.V; v++)
        {
            Iterator<Integer> it = adj[v].iterator();
            while(it.hasNext())
            {
                int u = it.next();
                g.addEdge(u,v);
            }
        }
        return g;
    }
    void fillStack(int u, boolean [] visited, Stack<Integer> stack)
    {
        visited[u] = true;
        Iterator<Integer> it = adj[u].iterator();
        while(it.hasNext())
        {
            int v = it.next();
            if(visited[v] == false)
            {
                fillStack(v, visited, stack);
            }
        }
        stack.push(u);
    }
    void dfsUtil(int u, boolean [] visited)
    {
        visited[u] = true;
        Iterator<Integer> it = adj[u].iterator();
        System.out.print(u + " ");
        while(it.hasNext())
        {
            int v = it.next();
            if(visited[v] == false)
            {
                dfsUtil(v, visited);
            }
        }
    }
    void getSCC()
    {
        boolean visited [] = new boolean[this.V];
        for(int i = 0; i < this.V; i++)
            visited[i] = false;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < this.V; i++)
        {
            if(visited[i] == false)
            {
                fillStack(i , visited, stack);
            }
        }
        SCC_Directed reverse_graph = getTranspose();
        for(int i = 0; i < this.V; i++)
            visited[i] = false;
        while(!stack.empty())
        {
            int u = stack.pop();
            if(visited[u] == false)
            {
                reverse_graph.dfsUtil(u,visited);
                System.out.println();
            }
        }
    }
    public static void main(String [] args)
    {
        SCC_Directed g = new SCC_Directed(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.getSCC();
    }
}
