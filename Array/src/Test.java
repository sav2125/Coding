import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by siddharthvarshney on 10/3/16.
 */
public class Test {
    public static void main(String args[])
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pq.add(5);
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(4);
        while(!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }
    }
}
