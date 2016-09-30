import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by siddharthvarshney on 9/10/16.
 */
public class TopologicalSort {
    private int V;
    private LinkedList<Integer> [] adj;
    TopologicalSort(int V)
    {
        this.V = V;
        adj = new LinkedList[this.V];
        for(int i = 0; i < this.V; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    void topologicalSortUtil(int u, boolean [] visited, Stack<Integer> s)
    {
        visited[u] = true;
        Iterator<Integer> it = adj[u].listIterator();
        while(it.hasNext())
        {
            int v = it.next();
            if(visited[v] == false)
                topologicalSortUtil(v,visited,s);
        }
        s.add(u);
    }
    void topologicalSort()
    {
        boolean [] visited = new boolean[this.V];
        for(int i=0;i < this.V;i++)
        {
            visited[i] = false;
        }
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<this.V;i++)
        {
            if(visited[i] == false)
            {
                topologicalSortUtil(i,visited,s);
            }
        }
        while(!s.empty())
        {
            System.out.print(s.pop() + " ");
        }
    }
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
